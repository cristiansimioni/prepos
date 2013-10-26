package prepos.rules.measures;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class AssociationMeasures {

    private float suzuki;

    public enum measures {

        SUZUKI; // Measure for exception rules
    }

    public float getSuzuki() {
        return suzuki;
    }

    public void setSuzuki(float suzuki) {
        this.suzuki = suzuki;
    }
}
