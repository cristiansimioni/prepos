package prepos.rules;

/*
 * Author: Cristian Simioni
 * Last update: 09/03/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class AttributeValue {

    // Attributes
    private String attribute;
    private String operator;
    private String value;

    // Constructor
    public AttributeValue() {
        this.attribute = "Not defined";
        this.operator = "Not defined";
        this.value = "Not defined";
    }

    // Getter & setter
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttribute() {
        return this.attribute;
    }

    // Override
    @Override
    public String toString() {
        return attribute + operator + value;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other instanceof AttributeValue) {
            if (this.toString().equals(((AttributeValue)other).toString())) {
                return true;
            }
        }
        return false;
    }
}