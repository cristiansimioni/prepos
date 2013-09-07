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
public class ParserAssociationPrepos {

    private String text;
    private ArrayList<AssociationRule> rules;

    public ParserAssociationPrepos(String text) {
        this.text = text;
        this.rules = new ArrayList<>();
    }

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
        strPremises = line.split("->")[0].trim();

        String[] premises = strPremises.split(" ");

        for (String premise : premises) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAttribute(premise.split("=", 2)[0]);
            attributeValue.setOperator("=");
            attributeValue.setValue(premise.split("=", 2)[1]);
            rule.addPremise(attributeValue);
        }
    }

    private void getConsequents(AssociationRule rule, String line) {
        String strConsequents;
        strConsequents = line.split("->")[1].trim();
        strConsequents = strConsequents.split("sup:")[0].trim();

        String[] consequents = strConsequents.split(" ");

        for (String consequent : consequents) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAttribute(consequent.split("=", 2)[0]);
            attributeValue.setOperator("=");
            attributeValue.setValue(consequent.split("=", 2)[1]);
            rule.addConsequent(attributeValue);
        }
    }

    private void getConfidence(AssociationRule rule, String line) {
        float confidence = 0.0f;
        String strConfidence;
        strConfidence = line.split("conf:")[1];
        strConfidence = strConfidence.split("\n")[0];

        confidence = Float.parseFloat(strConfidence);

        rule.setConfidence(confidence);
    }

    private void getSupport(AssociationRule rule, String line) {
        float support = 0.0f;
        String strSupport;
        strSupport = line.split("sup:")[1];
        strSupport = strSupport.split(" ")[0];

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
