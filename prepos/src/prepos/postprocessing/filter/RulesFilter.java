package prepos.postprocessing.filter;

import java.util.ArrayList;
import prepos.rules.AssociationRule;
import prepos.rules.AttributeValue;


public class RulesFilter {
    private ArrayList<AssociationRule> rules;
    private ArrayList<AttributeValue> selectedPremises;
    private ArrayList<AttributeValue> selectedConsequents;
    private float maxConfidence;
    private float minConfidence;
    private float minSupport;
    private float maxSupport;

    public RulesFilter(ArrayList<AttributeValue> selectedPremises, ArrayList<AttributeValue> selectedConsequents, float maxConfidence, float minConfidence, float minSupport, float maxSupport) {
        this.selectedPremises = selectedPremises;
        this.selectedConsequents = selectedConsequents;
        this.maxConfidence = maxConfidence;
        this.minConfidence = minConfidence;
        this.minSupport = minSupport;
        this.maxSupport = maxSupport;
        this.rules = new ArrayList<>();
    }
    
    
}
