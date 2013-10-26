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
public class Tree {

    // Attributes
    private ArrayList[] levels;
    private int numberOfLevels;

    // Constructor
    public Tree(int numberOfLevels) {
        this.numberOfLevels = numberOfLevels;
    }

    // Methods
    // Build the tree
    public void buildTree(ArrayList<TreeCondition> tree) {
        levels = new ArrayList[numberOfLevels + 1];
        for (int i = 0; i < levels.length; i++) {
            levels[i] = new ArrayList<>();
        }

        int[] controlLevels = new int[numberOfLevels + 1];
        for (int i = 0; i < controlLevels.length; i++) {
            controlLevels[i] = 0;
        }

        for (int i = 0; i < tree.size(); i++) {
            int level = tree.get(i).getLevel();
            controlLevels[level]++;
            TreeNode item = new TreeNode(tree.get(i).getItem());
            if (level != 0) {
                item.setPreviousLevel(controlLevels[level - 1] - 1);
            }
            this.levels[level].add(item);
            if (tree.get(i).isLeaf()) {
                TreeNode leaf = new TreeNode(tree.get(i).getLeaf());
                leaf.setPreviousLevel(controlLevels[level] - 1);
                leaf.setLeaf(true);
                leaf.setError(tree.get(i).getError());
                leaf.setSuccess(tree.get(i).getSuccess());
                controlLevels[level + 1]++;
                this.levels[level + 1].add(leaf);
            }
        }
    }

    // Get all rules from tree
    public ArrayList<ProductionRule> getRules() {
        ArrayList<ProductionRule> rules = new ArrayList<>();
        for (int i = levels.length - 1; i >= 0; i--) {
            for (int j = 0; j < levels[i].size(); j++) {
                int level = i;
                int previousLevel = ((TreeNode) levels[i].get(j)).getPreviousLevel();
                // Found a new rule
                if (((TreeNode) levels[i].get(j)).isLeaf()) {
                    ProductionRule newRule = new ProductionRule();
                    newRule.addConsequent(((TreeNode) levels[i].get(j)).getAttributeValue());
                    newRule.setSuccess(((TreeNode) levels[i].get(j)).getSuccess());
                    newRule.setError(((TreeNode) levels[i].get(j)).getError());
                    while (previousLevel != -1) {
                        level--;
                        newRule.addPremiseFirst(((TreeNode) levels[level].get(previousLevel)).getAttributeValue());
                        previousLevel = ((TreeNode) levels[level].get(previousLevel)).getPreviousLevel();
                    }
                    rules.add(newRule);
                }
            }
        }
        return rules;
    }
}
