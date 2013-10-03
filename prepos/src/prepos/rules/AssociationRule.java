package prepos.rules;

import java.util.ArrayList;

/*
 * Author: Cristian Simioni
 * Last update: 09/03/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 09/03/2013 | Cristian Simioni  | -                 | - 
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
        if (getPremises().size() < others.size()) {
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

    public boolean existsOnPremise(ArrayList<String> attributs) {
        for (String attribute : attributs) {
            for (AttributeValue premise : this.getPremises()) {
                if (premise.getAttribute().equals(attribute)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existsOnConsequent(ArrayList<String> attributs) {

        for (String attribute : attributs) {
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

        for (AttributeValue premise : getPremises()) {
            msg.append(premise.toString());
            msg.append(" ");
        }

        msg.append("-> ");

        for (AttributeValue consequent : getConsequents()) {
            msg.append(consequent.toString());
            msg.append(" ");
        }

        msg.append("sup:");
        msg.append(support);
        msg.append(" conf:");
        msg.append(confidence);

        return msg.toString();
    }
}
