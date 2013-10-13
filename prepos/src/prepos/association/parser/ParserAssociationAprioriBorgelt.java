package prepos.association.parser;

import java.util.ArrayList;
import prepos.rules.AssociationRule;
import prepos.rules.AttributeValue;

/*
 * Author: Cristian Simioni
 * Last update: 09/03/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class ParserAssociationAprioriBorgelt {

    // Attributes
    private String text;
    private ArrayList<AssociationRule> rules;

    // Constructor
    public ParserAssociationAprioriBorgelt(String text) {
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
        strPremises = line.split("<-")[1].trim();
        strPremises = strPremises.split("\\(")[0].trim();

        String[] premises = strPremises.split(" ");
        ArrayList<AttributeValue> allPremises = new ArrayList<>();

        for (String premise : premises) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAttribute(premise.substring(0, premise.lastIndexOf("_")));
            attributeValue.setOperator("=");
            attributeValue.setValue(premise.substring(premise.lastIndexOf("_") + 1));
            allPremises.add(attributeValue);
        }

        return allPremises;
    }

    // Get all consequents from rule
    private ArrayList<AttributeValue> getConsequents(String line) {
        String strConsequents;
        strConsequents = line.split("<-")[0].trim();

        String[] consequents = strConsequents.split(" ");
        ArrayList<AttributeValue> allConsequents = new ArrayList<>();

        for (String consequent : consequents) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAttribute(consequent.substring(0, consequent.lastIndexOf("_")));
            attributeValue.setOperator("=");
            attributeValue.setValue(consequent.substring(consequent.lastIndexOf("_") + 1));
            allConsequents.add(attributeValue);
        }

        return allConsequents;
    }

    // Get the confidence of rule
    private float getConfidence(String line) {
        String strCondifence;
        strCondifence = line.split("\\(")[1];
        strCondifence = strCondifence.split(",")[1].replace(")", "").trim();
        return Float.parseFloat(strCondifence);
    }

    // Get the support of rule
    private float getSupport(String line) {
        String strSupport;
        strSupport = line.split("\\(")[1];
        strSupport = strSupport.split(",")[0];
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
