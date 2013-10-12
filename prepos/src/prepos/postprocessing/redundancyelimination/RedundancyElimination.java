package prepos.postprocessing.redundancyelimination;

import java.util.ArrayList;
import prepos.rules.ProductionRule;

public class RedundancyElimination {

    // Attributes
    private ArrayList<ProductionRule> originalRules;
    private ArrayList<ProductionRule> withoutRedundancy;
    private int numberOfRulesWithRedundancy;
    private int numberOfRedundancies;
    private ArrayList<RedundancyItem> redundancyItems;

    // Constructor
    public RedundancyElimination(ArrayList<ProductionRule> rules) {
        this.originalRules = rules;
        this.redundancyItems = new ArrayList<>();
        this.numberOfRedundancies = 0;
        this.numberOfRulesWithRedundancy = 0;
    }

    // Getter & setter
    public ArrayList<RedundancyItem> getRedundancyItems() {
        return redundancyItems;
    }

    public int getNumberOfRulesWithRedundancy() {
        return numberOfRulesWithRedundancy;
    }

    public int getNumberOfRedundancy() {
        return numberOfRedundancies;
    }

    // Methods
    // Eliminates all redundancy
    public void eliminate() {
        /* Regras sem redundancia */
        this.withoutRedundancy = new ArrayList<>();

        /* Inicia vetor pra controlar as redundâncias */
        ArrayList[] redundantAttributes = new ArrayList[originalRules.size()];
        for (int i = 0; i < originalRules.size(); i++) {
            this.withoutRedundancy.add(new ProductionRule());
            redundantAttributes[i] = new ArrayList<>();
            for (int j = 0; j < originalRules.get(i).getPremises().size(); j++) {
                redundantAttributes[i].add(false);
            }
        }

        // Varre todas as regras
        for (int i = 0; i < this.originalRules.size(); i++) {
            // Varre todas a premissas procurando redundância
            for (int j = 0; j < originalRules.get(i).getPremises().size(); j++) {
                // Todos com todos
                for (int k = 0; k < originalRules.get(i).getPremises().size(); k++) {
                    // Se não for a mesma premissa
                    if (j != k) {
                        // Se for o mesmo operando e o mesmo atributo
                        if (originalRules.get(i).getIndexPremise(j).getOperator().equals(originalRules.get(i).getIndexPremise(k).getOperator()) && originalRules.get(i).getIndexPremise(j).getAttribute().equals(originalRules.get(i).getIndexPremise(k).getAttribute())) {
                            // Maior / Maior Igual
                            if (originalRules.get(i).getIndexPremise(j).getOperator().equals(">") || originalRules.get(i).getIndexPremise(j).getOperator().equals(">=")) {
                                if (Float.parseFloat(originalRules.get(i).getIndexPremise(j).getValue()) >= Float.parseFloat(originalRules.get(i).getIndexPremise(k).getValue())) {
                                    redundantAttributes[i].set(k, true);
                                } else if (Float.parseFloat(originalRules.get(i).getIndexPremise(j).getValue()) <= Float.parseFloat(originalRules.get(i).getIndexPremise(k).getValue())) {
                                    redundantAttributes[i].set(j, true);
                                }
                            }
                            // Menor / Menor Igual
                            if (originalRules.get(i).getIndexPremise(j).getOperator().equals("<") || originalRules.get(i).getIndexPremise(j).getOperator().equals("<=")) {
                                if (Float.parseFloat(originalRules.get(i).getIndexPremise(j).getValue()) <= Float.parseFloat(originalRules.get(i).getIndexPremise(k).getValue())) {
                                    redundantAttributes[i].set(k, true);
                                } else if (Float.parseFloat(originalRules.get(i).getIndexPremise(j).getValue()) >= Float.parseFloat(originalRules.get(i).getIndexPremise(k).getValue())) {
                                    redundantAttributes[i].set(j, true);
                                }
                            }
                            // IN
                            if (originalRules.get(i).getIndexPremise(j).getOperator().equals(" in ")) {
                                // TÁ ERRADO! CONFERIR ATRIBUTOS!
                                if (originalRules.get(i).getIndexPremise(j).getValue().length() > originalRules.get(i).getIndexPremise(k).getValue().length()) {
                                    redundantAttributes[i].set(j, true);
                                }
                                if (originalRules.get(i).getIndexPremise(j).getValue().length() < originalRules.get(i).getIndexPremise(k).getValue().length()) {
                                    redundantAttributes[i].set(k, true);
                                }
                            }
                        } else {
                            // Igual
                            if (originalRules.get(i).getIndexPremise(j).getAttribute().equals(originalRules.get(i).getIndexPremise(k).getAttribute())) {
                                if (originalRules.get(i).getIndexPremise(j).getOperator().equals("=")) {
                                    if (originalRules.get(i).getIndexPremise(k).getOperator().equals("!=") && originalRules.get(i).getIndexPremise(j).getValue().equals(originalRules.get(i).getIndexPremise(k).getValue())) {
                                        redundantAttributes[i].set(k, true);
                                    }
                                    if (originalRules.get(i).getIndexPremise(k).getOperator().equals(" in ") && originalRules.get(i).getIndexPremise(k).getValue().contains(originalRules.get(i).getIndexPremise(k).getValue())) {
                                        redundantAttributes[i].set(k, true);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }


        /* Elimina as redundâncias */
        for (int i = 0; i < originalRules.size(); i++) {
            for (int j = 0; j < originalRules.get(i).getPremises().size(); j++) {
                if (!(boolean) redundantAttributes[i].get(j)) {
                    this.withoutRedundancy.get(i).addPremise(originalRules.get(i).getIndexPremise(j));
                    if (!this.redundancyItems.contains(originalRules.get(i).getIndexPremise(j))) {
                        this.redundancyItems.add(new RedundancyItem(originalRules.get(i).getIndexPremise(j)));
                    } else {
                        this.redundancyItems.get(this.redundancyItems.indexOf(originalRules.get(i).getIndexPremise(j))).incrementItemRulesWith();
                    }
                } else {
                    if (!this.redundancyItems.contains(originalRules.get(i).getIndexPremise(j))) {
                        this.redundancyItems.add(new RedundancyItem(originalRules.get(i).getIndexPremise(j)));
                    } else {
                        this.redundancyItems.get(this.redundancyItems.indexOf(originalRules.get(i).getIndexPremise(j))).incrementItemRedundancy();
                    }
                }
            }
            this.withoutRedundancy.get(i).addConsequent(originalRules.get(i).getConsequents().get(0));
        }
    }
    
    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
            for (ProductionRule rule : this.withoutRedundancy) {
                msg.append(rule.toString());
                msg.append("\n");
            }
        
        return msg.toString();
    }

    public String statistics() {
        StringBuilder msg = new StringBuilder();

        msg.append("Number of rules: " + this.originalRules.size() + "\n");
        msg.append("Number of rules with redundancy: " + numberOfRulesWithRedundancy + "\n");
        msg.append("Number of redundancies: " + numberOfRedundancies + "\n");
        msg.append("Number of items: " + getRedundancyItems().size() + "\n\n");
        
        msg.append("Statistics of Items:\n\n");
        msg.append(String.format("%-30s","Item") + "\t" + String.format("%-15s","Rules With") + "\t" + String.format("%-15s","Redundancy Counter") + "\n");
        for(RedundancyItem item : getRedundancyItems()) {
            msg.append(String.format("%-30s", item.getAttribute().toString()) + "\t" + String.format("%-15s",item.getNumberOfRulesWith()) + "\t" + String.format("%-15s",item.getNumberOfRedundancy()) + "\n");
        }
        
        return msg.toString();
    }
}
