package prepos.classification.parser;

import java.util.ArrayList;
import prepos.rules.ProductionRule;

public class ParserClassifierJ48 {
    
    private ArrayList<ProductionRule> rules;
    private String text;
    private ArrayList<TreeCondition> conditions;

    public ParserClassifierJ48(String text) {
        this.text = text;
        this.conditions = new ArrayList<>();
    }
    
    public void buidProductionRules () {
        String lines [] = text.split("\n");
        for (String line : lines) {
            if (!line.contains("J48 pruned tree") && !line.isEmpty() && !line.contains("------------------") && !line.contains("Number of Leaves") && !line.contains("Size of the tree"))
            conditions.add(new TreeCondition(line));
        }
        
        int maxLevel = 0;
        for (TreeCondition condition : conditions) {
            if (condition.getLevel() > maxLevel) {
                maxLevel = condition.getLevel();
            }
        }
        maxLevel++;
        
        Tree tree = new Tree(maxLevel);
        tree.buildTree(conditions);
        this.rules = tree.getRules();
    }
    
        @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        
        for (ProductionRule rule : this.rules) {
            msg.append(rule.toString());
            msg.append("\n");
        }
        
        return msg.toString();
    }
}
