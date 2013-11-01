package prepos.postprocessing;

import java.util.ArrayList;
import prepos.rules.ProductionRule;

public class RedundancyElimination {

    // Attributes
    private ArrayList<ProductionRule> originalRules;
    private ArrayList<ProductionRule> withoutRedundancy;
    private RedundancyStatistics statistics;

    // Constructor
    public RedundancyElimination(ArrayList<ProductionRule> rules) {
        this.originalRules = rules;
        this.statistics = new RedundancyStatistics(originalRules.size());
    }

    // Methods
    // Eliminates all redundancies
    public void eliminate() {

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
                            if (originalRules.get(i).getIndexPremise(j).getOperator().equals(">>")) {
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


        // Eliminate redundacies
        for (int i = 0; i < originalRules.size(); i++) {
            boolean containsRedundancy = false;
            for (int j = 0; j < originalRules.get(i).getPremises().size(); j++) {
                // Verify if the item exists on the statistic list
                if (!statistics.getRedundancyItems().contains(new RedundancyItem(originalRules.get(i).getIndexPremise(j)))) {
                    statistics.getRedundancyItems().add(new RedundancyItem(originalRules.get(i).getIndexPremise(j)));
                }

                if (!(boolean) redundantAttributes[i].get(j)) {
                    this.withoutRedundancy.get(i).addPremise(originalRules.get(i).getIndexPremise(j));
                    // Increment the rules with of item
                    int index = statistics.getRedundancyItems().indexOf(new RedundancyItem(originalRules.get(i).getIndexPremise(j)));
                    statistics.getRedundancyItems().get(index).incrementItemRulesWith();
                } else {
                    // Contains redundancy
                    containsRedundancy = true;
                    // Increment the number of redundancies
                    int redundancies = statistics.getNumberOfRedundancies();
                    statistics.setNumberOfRedundancies(redundancies + 1);
                    // Increment the redundancies of item
                    int index = statistics.getRedundancyItems().indexOf(new RedundancyItem(originalRules.get(i).getIndexPremise(j)));
                    statistics.getRedundancyItems().get(index).incrementItemRedundancy();
                    statistics.getRedundancyItems().get(index).incrementItemRulesWith();
                }
            }
            this.withoutRedundancy.get(i).addConsequent(originalRules.get(i).getConsequents().get(0));
            this.withoutRedundancy.get(i).setError(originalRules.get(i).getError());
            this.withoutRedundancy.get(i).setSuccess(originalRules.get(i).getSuccess());

            // If the rule contains redundancy increment the number of redundancies
            if (containsRedundancy) {
                int rulesWithRedundacy = statistics.getNumberOfRulesWithRedundancy();
                statistics.setNumberOfRulesWithRedundancy(rulesWithRedundacy + 1);
            }
        }
    }

    // Get the statistcs
    public String statistics() {
        StringBuilder msg = new StringBuilder();

        msg.append("Number of rules: " + statistics.getNumberOfRules() + "\n");
        msg.append("Number of rules with redundancy: " + statistics.getNumberOfRulesWithRedundancy() + "\n");
        msg.append("Redundancy average: " + String.format("%.2f", statistics.redundancyAverage()) + "%\n");
        msg.append("Number of premises redundant: " + statistics.getNumberOfRedundancies() + "\n");
        msg.append("Redundancy premises per rule: " + String.format("%.2f", statistics.redundacnyItemsPerRule()) + "\n");
        msg.append("Number of distincts attribute-value: " + statistics.getRedundancyItems().size() + "\n\n");

        msg.append("Statistics of attribute-value:\n\n");
        msg.append(String.format("%-35s", "Item") + "\t" + String.format("%-15s", "Rules With") + "\t" + String.format("%-15s", "Redundancy Counter") + "\n");

        for (RedundancyItem item : statistics.getRedundancyItems()) {
            if (item.getAttribute().toString().length() > 33) {
                msg.append(String.format("%-35s", item.getAttribute().toString().substring(0, 33)) + "\t" + String.format("%-15s", item.getNumberOfRulesWith()) + "\t" + String.format("%-15s", item.getNumberOfRedundancy()) + "\n");
            } else {
                msg.append(String.format("%-35s", item.getAttribute().toString()) + "\t" + String.format("%-15s", item.getNumberOfRulesWith()) + "\t" + String.format("%-15s", item.getNumberOfRedundancy()) + "\n");
            }
        }

        return msg.toString();
    }

    // Override
    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("Production Rules:\n");
        for (ProductionRule rule : this.withoutRedundancy) {
            msg.append(rule.toString());
            msg.append("\n");
        }

        return msg.toString();
    }
}
