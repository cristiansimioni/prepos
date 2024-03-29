package prepos.association;

import prepos.database.Database;
import weka.associations.Apriori;

/*
 * Author: Cristian Simioni
 * Last updated: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class AssociationAprioriWeka implements Association {

    @Override
    public String getAssociations(Database database, String parameters) throws Exception {
        Apriori apriori = new Apriori();

        // Set parameters
        apriori.setOptions(parameters.split(" "));

        // Build associations 
        apriori.buildAssociations(database.getInstances());

        return apriori.toString();
    }
}
