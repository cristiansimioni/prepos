package prepos.association.parser;

import java.util.ArrayList;
import prepos.rules.AssociationRule;
import prepos.rules.AttributeValue;

public class ParserAssociationAprioriWeka {
    
    private String text;
    private ArrayList<AssociationRule> rules;
    private int numOfInstances;
    
    public ParserAssociationAprioriWeka(String text, int numOfInstances) {
        this.text = text;
        this.numOfInstances = numOfInstances;
        this.rules = new ArrayList<>();
    }
    
    // Build associations
    public void buildAssociationRules() {
        String[] lines = this.text.split("\n");
        for (String line : lines) {
            if (line.contains("==>")) {
                AssociationRule newRule = new AssociationRule();
                getPremises(newRule, line);
                getConsequents(newRule, line);
                getConfidence(newRule, line);
                getSupport(newRule, line);
                rules.add(newRule);
            }
        }
    }
    
    private void getPremises(AssociationRule rule, String line) {
        String strPremises;
        strPremises = line.substring(line.indexOf(". ")).replace(".", "").trim();
        strPremises = strPremises.split(" ==>")[0].trim();
        strPremises = strPremises.substring(0, strPremises.lastIndexOf(" "));
        
        String[] premises = strPremises.split(" ");
        
        for (String premise : premises) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAttribute(premise.split("=")[0]);
            attributeValue.setOperator("=");
            attributeValue.setValue(premise.split("=")[1]);
            rule.addPremise(attributeValue);
        }
    }
    
    private void getConsequents(AssociationRule rule, String line) {
        String strConsequents;
        strConsequents = line.split(">")[1].trim();
        strConsequents = strConsequents.split("<conf:")[0].trim();
        strConsequents = strConsequents.substring(0, strConsequents.lastIndexOf(" "));
        
        String[] consequents = strConsequents.split(" ");
        
        for (String consequent : consequents) {
            AttributeValue attributeValue = new AttributeValue();
            attributeValue.setAttribute(consequent.split("=")[0]);
            attributeValue.setOperator("=");
            attributeValue.setValue(consequent.split("=")[1]);
            rule.addConsequent(attributeValue);
        }
    }
    
    private void getConfidence(AssociationRule rule, String line) {
        float confidence = 0.0f;
        String strConfidence;
        strConfidence = line.split("<conf:")[1];
        strConfidence = strConfidence.replace("(", "");
        strConfidence = strConfidence.split("\\)")[0];
        
        confidence = Float.parseFloat(strConfidence);
        
        rule.setConfidence(confidence * 100);
    }
    
    private void getSupport(AssociationRule rule, String line) {
        float support;
        String strSupport [];
        strSupport = line.split(" ==>");
        strSupport = strSupport[0].split(" ");

        support = Float.parseFloat(strSupport[strSupport.length -1])/(float)this.numOfInstances;
        support *= 100;
        support = Math.round(support);
        
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
