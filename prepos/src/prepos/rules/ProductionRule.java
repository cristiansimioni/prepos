package prepos.rules;

import prepos.rules.measures.ClassificationMeasures;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class ProductionRule extends Rule {

    // Attributes
    private float success;
    private float error;
    private ClassificationMeasures measures;

    // Constructor
    public ProductionRule() {
        super();
        this.success = 0.0f;
        this.error = 0.0f;
        this.measures = new ClassificationMeasures();
    }

    // Getter & setter
    public float getSuccess() {
        return success;
    }

    public void setSuccess(float hit) {
        this.success = hit;
    }

    public float getError() {
        return error;
    }

    public void setError(float miss) {
        this.error = miss;
    }

    public ClassificationMeasures getMeasures() {
        return measures;
    }

    // Methods
    // Return the precision of production rule
    public float precision() {
        if (this.error == 0.0f) {
            return 100f;
        } else {
            return (1 - (this.error / this.success)) * 100;
        }
    }

    // Override
    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();

        msg.append(strPremise());
        msg.append(" -> ");
        msg.append(strConsequent());

        msg.append(" (");
        msg.append(success);
        msg.append(", ");
        msg.append(error);
        msg.append(")");

        return msg.toString();
    }
}
