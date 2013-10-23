package prepos.rules;

import java.util.ArrayList;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class AssociationRule extends Rule {

    // Attributes
    private float confidence;
    private float support;

    // Constructor
    public AssociationRule() {
        super();
        this.confidence = 0.0f;
        this.support = 0.0f;
    }

    // Getter & setter
    public float getConfidence() {
        return confidence;
    }

    public void setConfidence(float confidence) {
        this.confidence = confidence;
    }

    public float getSupport() {
        return support;
    }

    public void setSupport(float support) {
        this.support = support;
    }

    // Methods
    // Verify if a rule is an exception rule
    public boolean isExceptionRule(ArrayList<AttributeValue> others) {
        if (getPremises().size() <= others.size()) {
            return false;
        }

        boolean[] contains = new boolean[others.size()];
        for (int i = 0; i < contains.length; i++) {
            contains[i] = false;
        }

        for (int i = 0; i < others.size(); i++) {
            for (AttributeValue premise : getPremises()) {
                if (others.get(i).toString().equals(premise.toString())) {
                    contains[i] = true;
                }
            }
        }

        for (int i = 0; i < contains.length; i++) {
            if (!contains[i]) {
                return false;
            }
        }

        return true;
    }

    // Verify if exists one of items on premise
    public boolean existsOnPremise(ArrayList<String> attributes) {
        for (String attribute : attributes) {
            for (AttributeValue premise : this.getPremises()) {
                if (premise.getAttribute().equals(attribute)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Verify if exists one of items on consequent
    public boolean existsOnConsequent(ArrayList<String> attributes) {

        for (String attribute : attributes) {
            for (AttributeValue consequent : this.getConsequents()) {
                if (consequent.getAttribute().equals(attribute)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Override
    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();

        msg.append(strPremise());
        msg.append(" -> ");
        msg.append(strConsequent());

        msg.append(" sup:");
        msg.append(support);
        msg.append(" conf:");
        msg.append(confidence);

        return msg.toString();
    }
}
