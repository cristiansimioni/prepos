package prepos.classification.parser;

import java.util.ArrayList;
import prepos.rules.AttributeValue;
import prepos.rules.ProductionRule;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class ParserClassifierPrepos {

    // Attributes
    private String text;
    private ArrayList<ProductionRule> rules;

    // Constructor
    public ParserClassifierPrepos(String text) {
        this.text = text;
        this.rules = new ArrayList<>();
    }

    // Methods
    // Build production rules
    public void buildProductionRules() {
        String[] lines = this.text.split("\n");
        for (String line : lines) {
            ProductionRule newRule = new ProductionRule();
            newRule.setPremises(getPremises(line));
            newRule.setConsequents(getConsequents(line));
            newRule.setHit(getHit(line));
            newRule.setMiss(getMiss(line));
            rules.add(newRule);
        }
    }

    // Get all premises from rule
    private ArrayList<AttributeValue> getPremises(String line) {
        String strPremises;
        strPremises = line.split("->")[0].trim();

        String[] premises = strPremises.split(" ");
        ArrayList<AttributeValue> allPremises = new ArrayList<>();

        for (String premise : premises) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setOperator(operator(premise));
            attributeValue.setAttribute(premise.split(attributeValue.getOperator(), 2)[0]);
            attributeValue.setValue(premise.split(attributeValue.getOperator(), 2)[1]);
            allPremises.add(attributeValue);
        }
        
        return allPremises;
    }

    // Get all consequents from rule
    private ArrayList<AttributeValue> getConsequents(String line) {
        String strConsequents;
        strConsequents = line.split("->")[1].trim();
        strConsequents = strConsequents.split("miss:")[0].trim();

        String[] consequents = strConsequents.split(" ");
        ArrayList<AttributeValue> allConsequents = new ArrayList<>();

        for (String consequent : consequents) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAttribute(consequent.split("=", 2)[0]);
            attributeValue.setOperator("=");
            attributeValue.setValue(consequent.split("=", 2)[1]);
            allConsequents.add(attributeValue);
        }
        
        return allConsequents;
    }

    // Get the hit of rule
    private float getHit(String line) {
        String strHit;
        strHit = line.split("hit:")[1];
        strHit = strHit.split("\n")[0];
        return Float.parseFloat(strHit);
    }

    // Get the miss of rule
    private float getMiss(String line) {
        String strMiss;
        strMiss = line.split("miss:")[1];
        strMiss = strMiss.split(" ")[0];
        return Float.parseFloat(strMiss);
    }

    // Get the operator from attribute-value
    private String operator(String item) {
        if (item.contains(">=")) {
            return ">=";
        } else if (item.contains("<=")) {
            return "<=";
        } else if (item.contains(">")) {
            return ">";
        } else if (item.contains("<")) {
            return "<";
        } else if (item.contains("!=")) {
            return "!=";
        } else if (item.contains("=")) {
            return "=";
        } else if (item.contains(" in ")) {
            return " in ";
        } else {
            return "Not Defined.";
        }
    }

    // Get all rules
    public ArrayList<ProductionRule> getRules() {
        return rules;
    }

    // Override
    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();

        for (ProductionRule rule : this.rules) {
            msg.append(rule.toString());
            msg.append("\n");
        }

        return msg.toString();
    }
}
