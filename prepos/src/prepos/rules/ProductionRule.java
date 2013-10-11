package prepos.rules;

import java.util.ArrayList;

public class ProductionRule extends Rule {

    private float hit;
    private float miss;
    
    public ProductionRule() {
        super();
    }

    public float getHit() {
        return hit;
    }

    public void setHit(float hit) {
        this.hit = hit;
    }

    public float getMiss() {
        return miss;
    }

    public void setMiss(float miss) {
        this.miss = miss;
    }
    
    public float precision() {
        return this.miss/this.hit; 
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

        msg.append("miss:");
        msg.append(miss);
        msg.append(" hit:");
        msg.append(hit);

        return msg.toString();
    }
}
