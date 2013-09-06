package prepos.rules;

public class AttributeValue {

    private String attribute;
    private String operator;
    private String value;

    public AttributeValue() {
        this.attribute = "Not defined";
        this.operator = "Not defined";
        this.value = "Not defined";
    }

    /* Getter & Setter */
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

    /* Override */
    @Override
    public String toString() {
        return attribute + operator + value;
    }
}