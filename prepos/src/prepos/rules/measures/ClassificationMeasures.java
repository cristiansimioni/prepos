package prepos.rules.measures;

import java.util.ArrayList;
import prepos.database.Database;
import prepos.rules.AttributeValue;
import prepos.rules.ProductionRule;
import prepos.rules.ProductionRule;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class ClassificationMeasures {

    private float generalization;

    public enum measures {

        GERALIZATION;
    }

    public float getGeneralization() {
        return generalization;
    }

    public void setGeneralization(float generalization) {
        this.generalization = generalization;
    }
}
