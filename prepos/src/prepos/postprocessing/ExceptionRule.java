package prepos.postprocessing;

import java.util.ArrayList;
import prepos.rules.AssociationRule;

public class ExceptionRule {

    private AssociationRule originalRule;
    private ArrayList<AssociationRule> exceptionRules;

    public ExceptionRule(AssociationRule originalRule) {
        this.originalRule = originalRule;
        this.exceptionRules = new ArrayList<>();
    }

    public void addExceptionRule(AssociationRule exceptionRule) {
        this.exceptionRules.add(exceptionRule);
    }

    public int numOfExcpetionRule() {
        return this.exceptionRules.size();
    }

    public AssociationRule getOriginalRule() {
        return originalRule;
    }

    public void setOriginalRule(AssociationRule originalRule) {
        this.originalRule = originalRule;
    }

    public ArrayList<AssociationRule> getExceptionRules() {
        return exceptionRules;
    }

    public void setExceptionRules(ArrayList<AssociationRule> exceptionRules) {
        this.exceptionRules = exceptionRules;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        msg.append("Original:\n" + this.originalRule.toString());
        msg.append("\nException(s):\n");
        for (AssociationRule exception : this.exceptionRules) {
            msg.append(exception.toString());
            msg.append("\n");
        }
        msg.append("\n");
        return msg.toString();
    }
}
