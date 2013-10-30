package prepos.classification.parser;

import prepos.rules.AttributeValue;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public abstract class TreeCondition {

    // Attributes
    private String condition;

    // Constructor
    public TreeCondition(String condition) {
        this.condition = condition;
    }

    // Getter & setter
    public String getCondition() {
        return condition;
    }

    // Methods
    // Get level
    public int getLevel() {
        int level = 0;
        for (int i = 0; condition.charAt(i) == ' ' || condition.charAt(i) == '|'; i++) {
            if (condition.charAt(i) == '|') {
                level++;
            }
        }
        return level;
    }

    // Verify if is a leaf condition
    public boolean isLeaf() {
        if (condition.contains(":") && !condition.contains("[S")) {
            return true;
        } else {
            return false;
        }
    }

    // Get the item from a non-leaf node
    public AttributeValue getItem() {
        AttributeValue atrributeValue = new AttributeValue();
        String item = "";
        int i = 0;
        while (condition.charAt(i) == ' ' || condition.charAt(i) == '|') {
            i++;
        }
        if (!condition.contains(" in ")) {
            while (i < condition.length()) {
                if (condition.charAt(i) != ' ') {
                    item += condition.charAt(i);
                }
                i++;
            }
        } else {
            while (i < condition.length()) {
                item += condition.charAt(i);
                i++;
            }
        }

        // If if leaf node
        if (item.contains(":")) {
            item = item.split(":")[0];
        }

        // Verify operator
        if (item.contains(">=")) {
            atrributeValue.setAttribute(item.split(">")[0].trim());
            atrributeValue.setOperator(">=");
            atrributeValue.setValue(item.split("=")[1].trim());
        } else if (item.contains("<=")) {
            atrributeValue.setAttribute(item.split("<")[0].trim());
            atrributeValue.setOperator("<=");
            atrributeValue.setValue(item.split("=")[1].trim());
        } else if (item.contains(">")) {
            atrributeValue.setAttribute(item.split(">")[0].trim());
            atrributeValue.setOperator(">");
            atrributeValue.setValue(item.split(">")[1].trim());
        } else if (item.contains("<")) {
            atrributeValue.setAttribute(item.split("<")[0].trim());
            atrributeValue.setOperator("<");
            atrributeValue.setValue(item.split("<")[1].trim());
        } else if (item.contains("!=")) {
            atrributeValue.setAttribute(item.split("!")[0].trim());
            atrributeValue.setOperator("!=");
            atrributeValue.setValue(item.split("=")[1].trim());
        } else if (item.contains("=")) {
            atrributeValue.setAttribute(item.split("=")[0].trim());
            atrributeValue.setOperator("=");
            atrributeValue.setValue(item.split("=")[1].trim());
        } else if (item.contains(" in ")) {
            atrributeValue.setAttribute(item.split(" in ")[0].trim());
            atrributeValue.setOperator(">>");
            atrributeValue.setValue(item.split(" in ")[1].trim());
        }

        return atrributeValue;
    }

    // Get the item from a leaf node
    public AttributeValue getLeaf() {
        AttributeValue atrributeValue = new AttributeValue();
        String item = condition.split(":")[1].trim();

        atrributeValue.setAttribute("class");
        atrributeValue.setOperator("=");
        atrributeValue.setValue(item.split(" ")[0]);

        return atrributeValue;
    }

    // Get the success of leaf node
    public float getSuccess() {
        String success = "0.0";
        if (isLeaf()) {
            success = condition.substring(condition.indexOf("(", condition.indexOf(":")));
            success = success.replace("(", "");
            success = success.replace(")", "");

            if (success.contains("/")) {
                success = success.split("/")[0];
            }
        }
        return Float.parseFloat(success);
    }

    // Get the error of leaf node
    public float getError() {
        String error = "0.0";
        if (isLeaf()) {
            error = condition.substring(condition.indexOf("(", condition.indexOf(":")));
            error = error.replace("(", "");
            error = error.replace(")", "");

            if (error.contains("/")) {
                error = error.split("/")[1];
            } else {
                error = "0.0";
            }
        }
        return Float.parseFloat(error);
    }
}