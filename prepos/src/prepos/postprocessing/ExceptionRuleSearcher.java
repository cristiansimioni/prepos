package prepos.postprocessing;

import java.util.ArrayList;
import java.util.Hashtable;
import prepos.rules.AssociationRule;

public class ExceptionRuleSearcher {

    private ArrayList<AssociationRule> rules;
    private ArrayList<ExceptionRule> exceptionRules;
    private int numOfExceptionRules;
    private int numOfRulesWithException;

    public ExceptionRuleSearcher(ArrayList<AssociationRule> rules) {
        this.rules = rules;
        this.exceptionRules = new ArrayList<>();
        numOfExceptionRules = 0;
        numOfRulesWithException = 0;
    }

    public int getNumOfExceptionRules() {
        return numOfExceptionRules;
    }

    public int getNumOfRulesWithException() {
        return numOfRulesWithException;
    }

    public void find() {
        // Make a hash for a fast search
        Hashtable hash = new Hashtable();
        for (AssociationRule rule : rules) {
            if (rule.getConsequents().size() == 1) {
                ArrayList<AssociationRule> rulesById = (ArrayList<AssociationRule>) hash.get(rule.getConsequents().get(0).getAttribute());
                if (rulesById == null) {
                    rulesById = new ArrayList<>();
                    rulesById.add(rule);
                } else {
                    rulesById.add(rule);
                }
                hash.put(rule.getConsequents().get(0).getAttribute(), rulesById);
            }
        }

        int i = 1;
        for (AssociationRule rule : rules) {
            System.out.println(i + "/" + rules.size());
            ArrayList<AssociationRule> rulesSearch = (ArrayList<AssociationRule>) hash.get(rule.getConsequents().get(0).getAttribute());
            ExceptionRule exceptionRule = new ExceptionRule(rule);
            for (AssociationRule search : rulesSearch) {
                if (!rule.getConsequents().get(0).toString().equals(search.getConsequents().get(0).toString()) && search.isExceptionRule(rule.getPremises())) {
                    exceptionRule.addExceptionRule(search);
                }
            }
            if (exceptionRule.numOfExcpetionRule() > 0) {
                exceptionRules.add(exceptionRule);
                numOfRulesWithException++;
                numOfExceptionRules += exceptionRule.numOfExcpetionRule();
            }
            i++;
        }
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        if (this.exceptionRules.size() > 0) {
            for (ExceptionRule exception : this.exceptionRules) {
                msg.append(exception.toString());
            }
        } else {
            msg.append("No exceptions rule found.");
        }
        return msg.toString();
    }

    public String statistics() {
        String msg;
        msg = "Number of rules with exception: " + numOfRulesWithException + "\n";
        msg += "Number of exception rules: " + numOfExceptionRules + "\n";

        float mean = 0.0f;
        if (numOfExceptionRules != 0) {
            mean = (float) numOfExceptionRules / (float) numOfRulesWithException;
        }
        msg += "Mean of exceptions per rule: " + mean + "\n";
        return msg;
    }
}