package prepos.rules;

import java.util.ArrayList;

/*
 * Author: Cristian Simioni
 * Last update: 09/03/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 09/03/2013 | Cristian Simioni  | -                 | - 
 */
public abstract class Rule {

    private ArrayList<AttributeValue> premises;
    private ArrayList<AttributeValue> consequents;

    public Rule() {
        this.premises = new ArrayList<>();
        this.consequents = new ArrayList<>();
    }

    public ArrayList<AttributeValue> getPremises() {
        return premises;
    }

    public void setPremises(ArrayList<AttributeValue> premises) {
        this.premises = premises;
    }

    public ArrayList<AttributeValue> getConsequents() {
        return consequents;
    }

    public void setConsequents(ArrayList<AttributeValue> consequents) {
        this.consequents = consequents;
    }

    /* Adiciona uma premisa a lista */
    public void addPremise(AttributeValue premise) {
        this.premises.add(premise);
    }

    /* Adiciona uma premisa como primeiro elemento da lista */
    public void addPremiseFirst(AttributeValue premise) {
        this.premises.add(0, premise);
    }

    /* Remove uma premissa pelo índice */
    public void removePremise(int index) {
        this.premises.remove(index);
    }

    /* Pega uma premisa dado o índice */
    public AttributeValue getIndexPremise(int index) {
        return this.premises.get(index);
    }

    /* Quantidade de premissas da regra */
    public int getNumPremises() {
        return this.premises.size();
    }

    /* Adiciona uma premisa a lista */
    public void addConsequent(AttributeValue consequent) {
        this.consequents.add(consequent);
    }

    /* Adiciona uma premisa como primeiro elemento da lista */
    public void addConsequentFirst(AttributeValue consequent) {
        this.premises.add(0, consequent);
    }

    /* Remove uma premissa pelo índice */
    public void removeConsequent(int index) {
        this.consequents.remove(index);
    }

    /* Pega uma premisa dado o índice */
    public AttributeValue getIndexConsequent(int index) {
        return this.consequents.get(index);
    }

    /* Quantidade de premissas da regra */
    public int getNumConsequents() {
        return this.consequents.size();
    }

    public boolean containsPremises(ArrayList<AttributeValue> others) {
        if (this.premises.size() < others.size()) {
            return false;
        }

        boolean[] contains = new boolean[others.size()];
        for (int i = 0; i < contains.length; i++) {
            contains[i] = false;
        }

        for (int i = 0; i < others.size(); i++) {
            for (AttributeValue premise : this.premises) {
                if (others.get(i).toString().equals(premise.toString())) {
                    contains[i] = true;
                }
            }
        }

        for (int i = 0; i < contains.length; i++) {
            if (!contains[i]) {
                return false;
            }
        }

        return true;
    }
}