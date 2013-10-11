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
 * 09/03/2013 | Cristian Simioni  | -                 | - 
 */
public class ParserAssociationAprioriBorgelt {

    private String text;
    private ArrayList<AssociationRule> rules;

    public ParserAssociationAprioriBorgelt(String text) {
        this.text = text;
        this.rules = new ArrayList<>();
    }

    // Build associations
    public void buildAssociationRules() {
        String[] lines = this.text.split("\n");
        for (String line : lines) {
            AssociationRule newRule = new AssociationRule();
            getPremises(newRule, line);
            getConsequents(newRule, line);
            getConfidence(newRule, line);
            getSupport(newRule, line);
            rules.add(newRule);
        }
    }

    private void getPremises(AssociationRule rule, String line) {
        String strPremises;
        strPremises = line.split("<-")[1].trim();
        strPremises = strPremises.split("\\(")[0].trim();

        String[] premises = strPremises.split(" ");

        for (String premise : premises) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAttribute(premise.substring(0, premise.lastIndexOf("_")));
            attributeValue.setOperator("=");
            attributeValue.setValue(premise.substring(premise.lastIndexOf("_") + 1));
            rule.addPremise(attributeValue);
        }
    }

    private void getConsequents(AssociationRule rule, String line) {
        String strConsequents;
        strConsequents = line.split("<-")[0].trim();

        String[] consequents = strConsequents.split(" ");

        for (String consequent : consequents) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAttribute(consequent.substring(0, consequent.lastIndexOf("_")));
            attributeValue.setOperator("=");
            attributeValue.setValue(consequent.substring(consequent.lastIndexOf("_") + 1));
            rule.addConsequent(attributeValue);
        }
    }

    private void getConfidence(AssociationRule rule, String line) {
        float confidence;
        String strCondifence;
        strCondifence = line.split("\\(")[1];
        strCondifence = strCondifence.split(",")[1].replace(")", "").trim();

        confidence = Float.parseFloat(strCondifence);

        rule.setConfidence(confidence);
    }

    private void getSupport(AssociationRule rule, String line) {
        float support;
        String strSupport;
        strSupport = line.split("\\(")[1];
        strSupport = strSupport.split(",")[0];

        support = Float.parseFloat(strSupport);

        rule.setSupport(support);
    }

    public ArrayList<AssociationRule> getRules() {
        return rules;
    }

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
