package prepos.classification.parser;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class TreeConditionC45 extends TreeCondition {

    // Constructor
    public TreeConditionC45(String condition) {
        super(condition);
    }

    // Methods
    // Verify if is a sub tree
    public boolean isSubTree() {
        if (super.getCondition().contains("[S")) {
            return true;
        } else {
            return false;
        }
    }

    // Get the value of sub tree
    public int getSubTree() {
        int index = super.getCondition().indexOf("[");
        String sub = super.getCondition().substring(index);
        sub = sub.replace("[S", "");
        sub = sub.replace("]", "");
        return Integer.parseInt(sub);
    }
}
