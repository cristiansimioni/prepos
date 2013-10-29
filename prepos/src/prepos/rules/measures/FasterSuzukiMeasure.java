/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prepos.rules.measures;

import java.util.ArrayList;
import java.util.Hashtable;
import prepos.database.Database;
import prepos.postprocessing.ExceptionRule;
import prepos.rules.AssociationRule;
import prepos.rules.AttributeValue;
import weka.core.Instance;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class FasterSuzukiMeasure {

    private Database database;
    private ArrayList<ExceptionRule> rules;

    public FasterSuzukiMeasure(Database database, ArrayList<ExceptionRule> rules) {
        this.database = database;
        this.rules = rules;
    }

    public void calculate() {
        // Monta estrutura para calcular de forma eficaz
        /*ArrayList[] separateRules = new ArrayList[rules.size()];
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
         }*/

        Hashtable<String, Object> prRule = new Hashtable<String, Object>();
        Hashtable<String, Object> prItems = new Hashtable<String, Object>();

        // Build hashtable
        for (ExceptionRule exception : rules) {
            // Original Rule
            if (prRule.get(exception.getOriginalRule().toString()) == null) {
                prRule.put(exception.getOriginalRule().toString(), 0);
            }
            for (AttributeValue attr : exception.getOriginalRule().getPremises()) {
                if (prItems.get(attr.toString() + "," + exception.getOriginalRule().strConsequent()) == null) {
                    prItems.put(attr.toString() + "," + exception.getOriginalRule().strConsequent(), 0);
                }
            }
            // Exception Rules
            for (AssociationRule exc : exception.getExceptionRules()) {
                if (prRule.get(exc.toString()) == null) {
                    prRule.put(exc.toString(), 0);
                }
                for (AttributeValue attr : exc.getPremises()) {
                    if (prItems.get(attr.toString() + "," + exception.getOriginalRule().strConsequent()) == null) {
                        prItems.put(attr.toString() + "," + exception.getOriginalRule().strConsequent(), 0);
                    }
                }
            }
        }


        for (int i = 0; i < database.numInstances(); i++) {
            for (ExceptionRule exception : rules) {
                for (AttributeValue attr : exception.getOriginalRule().getPremises()) {
                    if (database.existsOnInstance(attr, i)) {
                        int current = (int) prItems.get(attr.toString() + "," + exception.getOriginalRule().strConsequent());
                        prItems.put(attr.toString() + "," + exception.getOriginalRule().strConsequent(), current + 1);
                    }
                }
                for (AssociationRule exc : exception.getExceptionRules()) {
                    for (AttributeValue attr : exc.getPremises()) {
                        if (database.existsOnInstance(attr, i)) {
                            int current = (int) prItems.get(attr.toString() + "," + exception.getOriginalRule().strConsequent());
                            prItems.put(attr.toString() + "," + exception.getOriginalRule().strConsequent(), current + 1);
                        }
                    }
                }
            }
        }


        for (ExceptionRule rule : rules) {
            float prOriginal = 0, prItemsOriginal = 1, prException = 0, prItemsException = 1;

            prOriginal = (int) prRule.get(rule.getOriginalRule().toString());
            prOriginal = Math.round((rule.getOriginalRule().getConfidence() * database.numInstances()) / 100);

            for (AttributeValue attr : rule.getOriginalRule().getPremises()) {
                prItemsOriginal *= (int) prItems.get(attr.toString() + "," + rule.getOriginalRule().strConsequent());
            }
            for (AssociationRule exception : rule.getExceptionRules()) {
                prException = (int) prRule.get(rule.getOriginalRule().toString());
                prException = Math.round((exception.getConfidence() * database.numInstances()) / 100);

                prItemsException = 1;
                for (AttributeValue attr : exception.getPremises()) {
                    prItemsException *= (int) prItems.get(attr.toString() + "," + rule.getOriginalRule().strConsequent());
                }

                float measure = (prOriginal * (float) Math.log10((double) prOriginal / prItemsOriginal))
                        + (prException * (float) Math.log10((double) prException / prItemsException));
                exception.getMeasures().setSuzuki(measure);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        if (rules.size() > 0) {
            for (ExceptionRule rule : rules) {
                msg.append("Original:\n");
                msg.append(rule.getOriginalRule().toString() + "\n");
                msg.append("\nException(s):\n");
                for (AssociationRule exception : rule.getExceptionRules()) {
                    msg.append(exception.toString() + " measure: " + exception.getMeasures().getSuzuki());
                    msg.append("\n");
                }
                msg.append("\n");
            }
        } else {
            msg.append("No exceptions rules found.");
        }

        return msg.toString();
    }
}