package prepos.postprocessing;

import java.util.ArrayList;
import prepos.rules.AssociationRule;

public class RulesFilter {

    // Attributes
    private ArrayList<AssociationRule> rules;
    private ArrayList<String> selectedPremises;
    private ArrayList<String> selectedConsequents;
    private float maxConfidence;
    private float minConfidence;
    private float minSupport;
    private float maxSupport;
    private boolean and;
    private boolean or;

    // Constructor
    public RulesFilter(ArrayList<AssociationRule> rules) {
        this.rules = rules;
        this.selectedConsequents = new ArrayList<>();
        this.selectedPremises = new ArrayList<>();
    }

    // Getter & setter
    public ArrayList<AssociationRule> getRules() {
        return rules;
    }

    public void setRules(ArrayList<AssociationRule> rules) {
        this.rules = rules;
    }

    public ArrayList<String> getSelectedPremises() {
        return selectedPremises;
    }

    public void setSelectedPremises(ArrayList<String> selectedPremises) {
        this.selectedPremises = selectedPremises;
    }

    public ArrayList<String> getSelectedConsequents() {
        return selectedConsequents;
    }

    public void setSelectedConsequents(ArrayList<String> selectedConsequents) {
        this.selectedConsequents = selectedConsequents;
    }

    public float getMaxConfidence() {
        return maxConfidence;
    }

    public void setMaxConfidence(float maxConfidence) {
        this.maxConfidence = maxConfidence;
    }

    public float getMinConfidence() {
        return minConfidence;
    }

    public void setMinConfidence(float minConfidence) {
        this.minConfidence = minConfidence;
    }

    public float getMinSupport() {
        return minSupport;
    }

    public void setMinSupport(float minSupport) {
        this.minSupport = minSupport;
    }

    public float getMaxSupport() {
        return maxSupport;
    }

    public void setMaxSupport(float maxSupport) {
        this.maxSupport = maxSupport;
    }

    public boolean isAnd() {
        return and;
    }

    public void setAnd(boolean and) {
        this.and = and;
    }

    public boolean isOr() {
        return or;
    }

    public void setOr(boolean or) {
        this.or = or;
    }

    public void addSelectedPremise(String premise) {
        if (!selectedPremises.contains(premise)) {
            selectedPremises.add(premise);
        }
    }

    public void removeSelectedPremise(String premise) {
        selectedPremises.remove(premise);
    }

    public void addSelectedConsequent(String consequent) {
        if (!selectedConsequents.contains(consequent)) {
            selectedConsequents.add(consequent);
        }
    }

    public void removeSelectedConsequent(String consequent) {
        selectedConsequents.remove(consequent);
    }

    public ArrayList<AssociationRule> filter() {
        ArrayList<AssociationRule> filteredRules = new ArrayList<>();

        for (AssociationRule rule : this.rules) {
            // Verify the parameters: confidence and support
            if (rule.getConfidence() >= minConfidence && rule.getConfidence() <= maxConfidence && rule.getSupport() >= minSupport && rule.getSupport() <= maxSupport) {
                if (or) {
                    // Verify if rule contains the selected premise OR selected consequent
                    if (rule.existsOnPremise(selectedPremises) || rule.existsOnConsequent(selectedConsequents)) {
                        filteredRules.add(rule);
                    }
                } else if (and) {
                    // Verify if rule contains the selected premise OR selected consequent 
                    if (rule.existsOnPremise(selectedPremises) && rule.existsOnConsequent(selectedConsequents)) {
                        filteredRules.add(rule);
                    }
                }
            }
        }

        return filteredRules;
    }
}
