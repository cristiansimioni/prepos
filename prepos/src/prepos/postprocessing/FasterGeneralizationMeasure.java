/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prepos.postprocessing;

import java.util.ArrayList;
import prepos.rules.ProductionRule;
import weka.core.Instances;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class FasterGeneralizationMeasure {

    private Instances instances;
    private ArrayList<ProductionRule> rules;
    private int rangeClass;

    public FasterGeneralizationMeasure(Instances instances, ArrayList<ProductionRule> rules) {
        this.instances = instances;
        this.rules = rules;
        this.rangeClass = instances.attribute(instances.classIndex()).numValues();
    }

    public void calculate() {
        // Monta estrutura para calcular de forma eficaz
        ArrayList[] separateRules = new ArrayList[rules.size()];
        ArrayList[] numValidValues = new ArrayList[rules.size()];
        for (int i = 0; i < rules.size(); i++) {
            separateRules[i] = new ArrayList();
            numValidValues[i] = new ArrayList();
            for (int j = 0; j < rules.get(i).getPremises().size(); j++) {
                ProductionRule newRule = new ProductionRule();
                newRule.addPremise(rules.get(i).getIndexPremise(j));
                newRule.addConsequent(rules.get(i).getConsequents().get(0));
                separateRules[i].add(newRule);
                numValidValues[i].add(0);
            }
        }


        for (int i = 0; i < instances.numInstances(); i++) {
            for (int j = 0; j < separateRules.length; j++) {
                for (int k = 0; k < separateRules[j].size(); k++) {
                    ProductionRule ruleToTest = (ProductionRule) separateRules[j].get(k);
                    if (!ruleToTest.getConsequents().get(0).getValue().equals(instances.instance(i).stringValue(instances.classIndex()))) {
                        if (ruleToTest.getIndexPremise(0).getOperator().equals(">")) {
                            if (Double.parseDouble(ruleToTest.getIndexPremise(0).getValue()) > instances.instance(i).value(instances.attribute(ruleToTest.getIndexPremise(0).getAttribute()).index())) {
                                numValidValues[j].set(k, (int) numValidValues[j].get(k) + 1);
                            }
                        } else if (ruleToTest.getIndexPremise(0).getOperator().equals(">=")) {
                            if (Double.parseDouble(ruleToTest.getIndexPremise(0).getValue()) >= instances.instance(i).value(instances.attribute(ruleToTest.getIndexPremise(0).getAttribute()).index())) {
                                numValidValues[j].set(k, (int) numValidValues[j].get(k) + 1);
                            }
                        } else if (ruleToTest.getIndexPremise(0).getOperator().equals("<")) {
                            if (Double.parseDouble(ruleToTest.getIndexPremise(0).getValue()) < instances.instance(i).value(instances.attribute(ruleToTest.getIndexPremise(0).getAttribute()).index())) {
                                numValidValues[j].set(k, (int) numValidValues[j].get(k) + 1);
                            }
                        } else if (ruleToTest.getIndexPremise(0).getOperator().equals("<=")) {
                            if (Double.parseDouble(ruleToTest.getIndexPremise(0).getValue()) <= instances.instance(i).value(instances.attribute(ruleToTest.getIndexPremise(0).getAttribute()).index())) {
                                numValidValues[j].set(k, (int) numValidValues[j].get(k) + 1);
                            }
                        } else if (ruleToTest.getIndexPremise(0).getOperator().equals("=")) {
                            if (instances.attribute(ruleToTest.getIndexPremise(0).getAttribute()).isNumeric()) {
                                if (Double.parseDouble(ruleToTest.getIndexPremise(0).getValue()) == instances.instance(i).value(instances.attribute(ruleToTest.getIndexPremise(0).getAttribute()).index())) {
                                    numValidValues[j].set(k, (int) numValidValues[j].get(k) + 1);
                                }
                            } else {
                                if (ruleToTest.getIndexPremise(0).getValue().equals(instances.instance(i).value(instances.attribute(ruleToTest.getIndexPremise(0).getAttribute()).index()))) {
                                    numValidValues[j].set(k, (int) numValidValues[j].get(k) + 1);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rules.size(); i++) {
            float measure = 0.0f;
            for (int j = 0; j < separateRules[i].size(); j++) {
                if ((int) numValidValues[i].get(j) <= (instances.numInstances() / rangeClass)) {
                    measure++;
                }
            }
            rules.get(i).getMeasures().setGeneralization(measure / rules.get(i).getPremises().size());
        }
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        for (ProductionRule rule : rules) {
            msg.append(rule.toString() + " measure: " + rule.getMeasures().getGeneralization() + "\n");
        }
        return msg.toString();
    }
}
