package prepos.association.parser;

import java.util.ArrayList;
import prepos.rules.AssociationRule;
import prepos.rules.AttributeValue;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class ParserAssociationPrepos {

    // Attributes
    private String text;
    private ArrayList<AssociationRule> rules;

    // Constructor
    public ParserAssociationPrepos(String text) {
        this.text = text;
        this.rules = new ArrayList<>();
    }

    // Methods
    // Build associations
    public void buildAssociationRules() {
        String[] lines = this.text.split("\n");
        for (String line : lines) {
            AssociationRule newRule = new AssociationRule();
            newRule.setPremises(getPremises(line));
            newRule.setConsequents(getConsequents(line));
            newRule.setSupport(getSupport(line));
            newRule.setConfidence(getConfidence(line));
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
            attributeValue.setAttribute(premise.split("=", 2)[0]);
            attributeValue.setOperator("=");
            attributeValue.setValue(premise.split("=", 2)[1]);
            allPremises.add(attributeValue);
        }

        return allPremises;
    }

    // Get all consequents from rule
    private ArrayList<AttributeValue> getConsequents(String line) {
        String strConsequents;
        strConsequents = line.split("->")[1].trim();
        strConsequents = strConsequents.split("sup:")[0].trim();

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

    // Get the confidence of rule
    private float getConfidence(String line) {
        String strConfidence;
        strConfidence = line.split("conf:")[1];
        strConfidence = strConfidence.split("\n")[0];
        return Float.parseFloat(strConfidence);
    }

    // Get the support of rule
    private float getSupport(String line) {
        String strSupport;
        strSupport = line.split("sup:")[1];
        strSupport = strSupport.split(" ")[0];
        return Float.parseFloat(strSupport);
    }

    // Get all rules
    public ArrayList<AssociationRule> getRules() {
        return rules;
    }

    // Override
    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();

        for (AssociationRule rule : this.rules) {
            msg.append(rule.toString());
            msg.append("\n");
        }

        return msg.toString();
    }
}
