package prepos.rules;

/*
 * Author: Cristian Simioni
 * Last update: 09/03/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class ProductionRule extends Rule {

    // Attributes
    private float hit;
    private float miss;

    // Constructor
    public ProductionRule() {
        super();
        this.hit = 0.0f;
        this.miss = 0.0f;
    }

    // Getter & setter
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

    // Methods
    // Return the precision of production rule
    public float precision() {
        return this.miss / this.hit;
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
