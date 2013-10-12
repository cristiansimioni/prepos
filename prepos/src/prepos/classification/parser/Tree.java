package prepos.classification.parser;

import java.util.ArrayList;
import prepos.rules.ProductionRule;

public class Tree {

    private ArrayList[] levels;
    private int numberOfLevels;

    public Tree(int numberOfLevels) {
        this.numberOfLevels = numberOfLevels;
        levels = new ArrayList[numberOfLevels + 1];
        for (int i = 0; i < levels.length; i++) {
            levels[i] = new ArrayList<>();
        }
    }
    
    public void buildTree(ArrayList<TreeCondition> tree) {
        int[] controlLevels = new int[numberOfLevels + 1];
        for (int i = 0; i < controlLevels.length; i++) {
            controlLevels[i] = 0;
        }

        for (int i = 0; i < tree.size(); i++) {
            // Debug: System.out.println(tree.get(i).getCondition());
            int level = tree.get(i).getLevel();
            controlLevels[level]++;
            TreeNode item = new TreeNode(tree.get(i).getItem());
            if (level != 0) {
                item.setPreviousLevel(controlLevels[level - 1] - 1);
            }
            this.levels[level].add(item);
            if (tree.get(i).isLeaf()) {
                TreeNode leaf = new TreeNode(tree.get(i).getLeave());
                leaf.setPreviousLevel(controlLevels[level] - 1);
                leaf.setLeaf(true);
                leaf.setMiss(0.0f);
                leaf.setHit(0.0f);
                controlLevels[level + 1]++;
                this.levels[level + 1].add(leaf);
            }
        }
    }

    public ArrayList<ProductionRule> getRules() {
        ArrayList<ProductionRule> rules = new ArrayList<>();
        for (int i = levels.length - 1; i >= 0; i--) {
            for (int j = 0; j < levels[i].size(); j++) {
                int nivel = i;
                int indiceNivelAnterior = ((TreeNode) levels[i].get(j)).getPreviousLevel();
                // Find a new rule
                if (((TreeNode) levels[i].get(j)).isLeaf()) {
                    ProductionRule newRule = new ProductionRule();
                    newRule.addConsequent(((TreeNode) levels[i].get(j)).getAttributeValue());
                    newRule.setHit(((TreeNode) levels[i].get(j)).getHit());
                    newRule.setMiss(((TreeNode) levels[i].get(j)).getMiss());
                    while (indiceNivelAnterior != -1) {
                        nivel--;
                        newRule.addPremiseFirst(((TreeNode) levels[nivel].get(indiceNivelAnterior)).getAttributeValue());
                        indiceNivelAnterior = ((TreeNode) levels[nivel].get(indiceNivelAnterior)).getPreviousLevel();
                    }
                    rules.add(newRule);
                }
            }
        }
        return rules;
    }
}
