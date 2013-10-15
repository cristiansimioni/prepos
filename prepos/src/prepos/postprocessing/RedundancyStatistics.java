package prepos.postprocessing;

import java.util.ArrayList;

public class RedundancyStatistics {

    // Attributes
    private int numberOfRules;
    private int numberOfRulesWithRedundancy;
    private int numberOfRedundancies;
    private ArrayList<RedundancyItem> redundancyItems;

    // Getter & setter
    public RedundancyStatistics(int numberOfRules) {
        this.numberOfRules = numberOfRules;
        this.redundancyItems = new ArrayList<>();
    }

    public int getNumberOfRules() {
        return numberOfRules;
    }

    public void setNumberOfRules(int numberOfRules) {
        this.numberOfRules = numberOfRules;
    }

    public int getNumberOfRulesWithRedundancy() {
        return numberOfRulesWithRedundancy;
    }

    public void setNumberOfRulesWithRedundancy(int numberOfRulesWithRedundancy) {
        this.numberOfRulesWithRedundancy = numberOfRulesWithRedundancy;
    }

    public int getNumberOfRedundancies() {
        return numberOfRedundancies;
    }

    public void setNumberOfRedundancies(int numberOfRedundancies) {
        this.numberOfRedundancies = numberOfRedundancies;
    }

    public ArrayList<RedundancyItem> getRedundancyItems() {
        return redundancyItems;
    }

    public void setRedundancyItems(ArrayList<RedundancyItem> redundancyItems) {
        this.redundancyItems = redundancyItems;
    }

    // Methods
    public float redundancyAverage() {
        return ((float) numberOfRulesWithRedundancy / (float) numberOfRules) * 100;
    }

    public float redundacnyItemsPerRule() {
        return ((float) numberOfRedundancies / (float) numberOfRules);
    }
}
