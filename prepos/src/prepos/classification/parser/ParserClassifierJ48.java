package prepos.classification.parser;

import java.util.ArrayList;
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
public class ParserClassifierJ48 {

    // Attributes
    private ArrayList<ProductionRule> rules;
    private String text;

    // Constructor
    public ParserClassifierJ48(String text) {
        this.text = text;
    }

    // Methods
    // Build production rules
    public void buidProductionRules() {

        String lines[] = text.split("\n");
        ArrayList<TreeCondition> conditions = new ArrayList<>();

        // Preprocess the lines with conditions
        for (String line : lines) {
            if (!line.contains("J48 pruned tree") && !line.isEmpty() && !line.contains("------------------") && !line.contains("Number of Leaves") && !line.contains("Size of the tree")) {
                conditions.add(new TreeConditionJ48(line));
            }
        }

        // Get the max level of tree
        int maxLevel = 0;
        for (TreeCondition condition : conditions) {
            if (condition.getLevel() > maxLevel) {
                maxLevel = condition.getLevel();
            }
        }
        // Increment the max level because root node needs a level as well
        maxLevel++;

        // Build the tree
        Tree tree = new Tree(maxLevel);
        tree.buildTree(conditions);
        this.rules = tree.getRules();
    }

    // Override
    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();

        msg.append("Production Rules:\n");
        for (ProductionRule rule : this.rules) {
            // Eliminate the rules with error/success 0
            if (rule.getError() + rule.getSuccess() != 0.0f) {
                msg.append(rule.toString());
                msg.append("\n");
            }
        }

        return msg.toString();
    }
}
