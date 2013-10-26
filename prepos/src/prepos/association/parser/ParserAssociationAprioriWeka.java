package prepos.association.parser;

import java.util.ArrayList;
import prepos.rules.AssociationRule;
import prepos.rules.AttributeValue;

/*
 * Author: Cristian Simioni
 * Last updated: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class ParserAssociationAprioriWeka {

    // Attributes
    private String text;
    private ArrayList<AssociationRule> rules;
    private int numOfInstances;

    // Constructor
    public ParserAssociationAprioriWeka(String text, int numOfInstances) {
        this.text = text;
        this.numOfInstances = numOfInstances;
        this.rules = new ArrayList<>();
    }

    // Methods
    // Build associations
    public void buildAssociationRules() {
        String[] lines = this.text.split("\n");
        for (String line : lines) {
            if (line.contains("==>")) {
                AssociationRule newRule = new AssociationRule();
                newRule.setPremises(getPremises(line));
                newRule.setConsequents(getConsequents(line));
                newRule.setSupport(getSupport(line));
                newRule.setConfidence(getConfidence(line));
                rules.add(newRule);
            }
        }
    }

    // Get all premises from rule
    private ArrayList<AttributeValue> getPremises(String line) {
        String strPremises;
        strPremises = line.substring(line.indexOf(". ")).replace(".", "").trim();
        strPremises = strPremises.split(" ==>")[0].trim();
        strPremises = strPremises.substring(0, strPremises.lastIndexOf(" "));

        String[] premises = strPremises.split(" ");
        ArrayList<AttributeValue> allPremises = new ArrayList<>();

        for (String premise : premises) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAttribute(premise.split("=")[0]);
            attributeValue.setOperator("=");
            attributeValue.setValue(premise.split("=")[1]);
            allPremises.add(attributeValue);
        }

        return allPremises;
    }

    // Get all consequents from rule
    private ArrayList<AttributeValue> getConsequents(String line) {
        String strConsequents;
        strConsequents = line.split(">")[1].trim();
        strConsequents = strConsequents.split("<conf:")[0].trim();
        strConsequents = strConsequents.substring(0, strConsequents.lastIndexOf(" "));

        String[] consequents = strConsequents.split(" ");
        ArrayList<AttributeValue> allConsequents = new ArrayList<>();

        for (String consequent : consequents) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAttribute(consequent.split("=")[0]);
            attributeValue.setOperator("=");
            attributeValue.setValue(consequent.split("=")[1]);
            allConsequents.add(attributeValue);
        }

        return allConsequents;
    }

    // Get the confidence of rule
    private float getConfidence(String line) {
        String strConfidence;
        strConfidence = line.split("<conf:")[1];
        strConfidence = strConfidence.replace("(", "");
        strConfidence = strConfidence.split("\\)")[0];
        return Float.parseFloat(strConfidence) * 100;
    }

    // Get the support of rule
    private float getSupport(String line) {
        float support;
        String strSupport[];
        strSupport = line.split(" ==>");
        strSupport = strSupport[0].split(" ");

        // Calculate the support of rule
        support = Float.parseFloat(strSupport[strSupport.length - 1]) / (float) this.numOfInstances;
        support *= 100;
        // Round the value of support
        support = Math.round(support);

        return support;
    }

    // Get all rules
    public ArrayList<AssociationRule> getRules() {
        return rules;
    }

    // Override
    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();

        msg.append("Association Rules:\n");
        for (AssociationRule rule : this.rules) {
            msg.append(rule.toString());
            msg.append("\n");
        }

        return msg.toString();
    }
}
