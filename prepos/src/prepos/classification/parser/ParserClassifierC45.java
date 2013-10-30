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
public class ParserClassifierC45 {

    // Attributes
    private ArrayList<ProductionRule> rules;
    private String text;
    private int tree; // 0: decision tree | 1: simplified decision tree

    // Constructor
    public ParserClassifierC45(String text, int tree) {
        this.text = text;
        this.tree = tree;
    }

    // Methods
    // Preprocess the text
    private ArrayList<String> preprocess() {
        int i = 0;
        String[] arrayLines = text.split("\n");
        ArrayList<String> lines = new ArrayList<>();
        boolean flagDecisionTree = false;
        boolean flagTreeSaved = false;
        boolean flagSpecial = false;
        while (i < arrayLines.length) {
            String line = arrayLines[i];
            if (line.contains("Decision Tree")) {
                flagDecisionTree = true;
            } else if (line.contains("Tree saved")) {
                flagTreeSaved = true;
            }
            if (!line.contains(":") && !line.equals("") && !line.contains("Subtree [S") && !flagTreeSaved && flagDecisionTree) {
                String auxLine = line;
                i++;
                line = arrayLines[i];
                while (!line.contains(":") && !line.equals("")) {
                    auxLine += line.replace("|", "").trim();
                    i++;
                    line = arrayLines[i];
                }
                if (!line.equals("")) {
                    auxLine += line.replace("|", "").trim();
                }
                flagSpecial = true;
                String test = auxLine.split("}")[1];
                if (!test.contains("(") && !test.contains(")") && !test.contains("[") && !test.contains("]")) {
                    auxLine = auxLine.replace(":", "");
                    auxLine = auxLine.replace(" :", "");
                    auxLine = auxLine.replace("}:", "}");
                }
                lines.add(auxLine);
            }
            if (!line.contains("(") && !line.contains(")") && !line.contains("[") && !line.contains("]")) {
                line = line.replace(":", "");
                line = line.replace(" :", "");
                line = line.replace("}:", "}");
            }
            if (flagDecisionTree && !flagTreeSaved && !flagSpecial) {
                lines.add(line);
            }
            if (flagSpecial) {
                flagSpecial = false;
            }
            i++;
        }
        return lines;
    }

    // Build production rules
    public void buidProductionRules() {


        ArrayList<TreeCondition> conditions = new ArrayList<>();
        ArrayList<String> lines = new ArrayList<>();
        //lines.addAll(Arrays.asList(text.split("\n")));

        lines = preprocess();
        // Preprocess the lines with conditions
        int index = 0;
        if (this.tree == 0) {
            index = lines.indexOf("Decision Tree") + 2;
        } else if (this.tree == 1) {
            index = lines.indexOf("Simplified Decision Tree") + 2;
        }
        while (!lines.get(index).isEmpty()) {
            conditions.add(new TreeConditionC45(lines.get(index)));
            index++;
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
            if (rule.precision() > 0.0f) {
                msg.append(rule.toString());
                msg.append("\n");
            }
        }

        return msg.toString();
    }
}
