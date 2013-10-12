package prepos.postprocessing.redundancyelimination;

import prepos.rules.AttributeValue;

public class RedundancyItem {

    // Attributes
    private AttributeValue attribute;
    private int numberOfRulesWith;
    private int numberOfRedundancy;

    // Constructor
    public RedundancyItem(AttributeValue attribute) {
        this.attribute = attribute;
        this.numberOfRedundancy = 0;
    }

    // Getter & setter
    public AttributeValue getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeValue attribute) {
        this.attribute = attribute;
    }

    public int getNumberOfRedundancy() {
        return numberOfRedundancy;
    }

    public void setNumberOfRedundancy(int numberOfRedundancy) {
        this.numberOfRedundancy = numberOfRedundancy;
    }

    public int getNumberOfRulesWith() {
        return numberOfRulesWith;
    }

    public void setNumberOfRulesWith(int numberOfRulesWith) {
        this.numberOfRulesWith = numberOfRulesWith;
    }

    // Methods
    // Increment the counter for redundancy
    public void incrementItemRedundancy() {
        this.numberOfRedundancy += 1;
    }
    
    // Increment the counter for rules with
     public void incrementItemRulesWith() {
        this.numberOfRulesWith += 1;
    }

    // Override
    @Override
    public boolean equals(Object other) {
        if (other instanceof RedundancyItem) {
            if (this.attribute.equals(((RedundancyItem) other).getAttribute())) {
                return true;
            }
        }
        return false;
    }
}
