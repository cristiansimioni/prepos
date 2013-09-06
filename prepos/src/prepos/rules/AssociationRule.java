package prepos.rules;

import java.util.ArrayList;


public class AssociationRule extends Rule {
    
    private float confidence;
    private float support;

    public AssociationRule() {
        super();
        this.confidence = 0.0f;
        this.support = 0.0f;
    }

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
    
    
    
    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        
        for(AttributeValue premise : getPremises()) {
            msg.append(premise.toString());
            msg.append(" ");
        }
        
        msg.append("-> ");
        
        for(AttributeValue consequent : getConsequents()) {
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
