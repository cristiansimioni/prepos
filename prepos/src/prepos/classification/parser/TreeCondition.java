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
public class TreeCondition {

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

    public boolean isSubTree() {
        if (condition.contains("[S")) {
            return true;
        } else {
            return false;
        }
    }

    public int getSubTree() {
        int index = condition.indexOf("[");
        String sub = condition.substring(index);
        sub = sub.replace("[S", "");
        sub = sub.replace("]", "");
        return Integer.parseInt(sub);
    }

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

        // Se for nó folha
        if (item.contains(":")) {
            item = item.split(":")[0];
        }

        // Verifica operador
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
            atrributeValue.setOperator(" in ");
            atrributeValue.setValue(item.split(" in ")[1].trim());
        }

        return atrributeValue;
    }

    public AttributeValue getLeave() {
        AttributeValue atrributeValue = new AttributeValue();
        String item = condition.split(":")[1].trim();

        atrributeValue.setAttribute("class");
        atrributeValue.setOperator("=");
        atrributeValue.setValue(item.split(" ")[0]);

        return atrributeValue;
    }

    public float getPrecision() {
        if (isLeaf()) {
            String precision = condition.substring(condition.indexOf("(", condition.indexOf(":")));
            precision = precision.replace("(", "");
            precision = precision.replace(")", "");
            if (precision.contains("|")) {
                precision = precision.split("\\|")[1];
            }
            if (precision.contains("/")) {
                String amount = precision.split("/")[0];
                String hits = precision.split("/")[1];
                return (Float.parseFloat(hits) * 100) / (Float.parseFloat(amount));
            } else if (Float.parseFloat(precision) > 0.0) {
                return 100f;
            } else {
                return 0;
            }
        }
        return 0f;
    }

    public String getInfoPrecision() {
        return condition.substring(condition.indexOf("(", condition.indexOf(":")));
    }
}