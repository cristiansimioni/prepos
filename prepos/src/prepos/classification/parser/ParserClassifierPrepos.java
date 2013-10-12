package prepos.classification.parser;

import prepos.association.parser.*;
import java.util.ArrayList;
import prepos.rules.AssociationRule;
import prepos.rules.AttributeValue;
import prepos.rules.ProductionRule;

/*
 * Author: Cristian Simioni
 * Last update: 09/03/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 09/03/2013 | Cristian Simioni  | -                 | - 
 */
public class ParserClassifierPrepos {

    private String text;
    private ArrayList<ProductionRule> rules;

    public ParserClassifierPrepos(String text) {
        this.text = text;
        this.rules = new ArrayList<>();
    }

    // Build production rules
    public void buildProductionRules() {
        String[] lines = this.text.split("\n");
        for (String line : lines) {
            ProductionRule newRule = new ProductionRule();
            getPremises(newRule, line);
            getConsequents(newRule, line);
            getHit(newRule, line);
            getMiss(newRule, line);
            rules.add(newRule);
        }
    }

    private void getPremises(ProductionRule rule, String line) {
        String strPremises;
        strPremises = line.split("->")[0].trim();

        String[] premises = strPremises.split(" ");

        for (String premise : premises) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setOperator(operator(premise));
            attributeValue.setAttribute(premise.split(attributeValue.getOperator(), 2)[0]);
            attributeValue.setValue(premise.split(attributeValue.getOperator(), 2)[1]);
            rule.addPremise(attributeValue);
        }
    }

    private void getConsequents(ProductionRule rule, String line) {
        String strConsequents;
        strConsequents = line.split("->")[1].trim();
        strConsequents = strConsequents.split("miss:")[0].trim();

        String[] consequents = strConsequents.split(" ");

        for (String consequent : consequents) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAttribute(consequent.split("=", 2)[0]);
            attributeValue.setOperator("=");
            attributeValue.setValue(consequent.split("=", 2)[1]);
            rule.addConsequent(attributeValue);
        }
    }

    private void getHit(ProductionRule rule, String line) {
        float hit = 0.0f;
        String strHit;
        strHit = line.split("hit:")[1];
        strHit = strHit.split("\n")[0];

        hit = Float.parseFloat(strHit);

        rule.setHit(hit);
    }

    private void getMiss(ProductionRule rule, String line) {
        float miss = 0.0f;
        String strMiss;
        strMiss = line.split("miss:")[1];
        strMiss = strMiss.split(" ")[0];

        miss = Float.parseFloat(strMiss);

        rule.setMiss(miss);
    }

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

    public ArrayList<ProductionRule> getRules() {
        return rules;
    }

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
