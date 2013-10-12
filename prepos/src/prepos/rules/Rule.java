package prepos.rules;

import java.util.ArrayList;

/*
 * Author: Cristian Simioni
 * Last update: 09/03/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public abstract class Rule {

    // Attributes
    private ArrayList<AttributeValue> premises;
    private ArrayList<AttributeValue> consequents;

    // Constructor
    public Rule() {
        this.premises = new ArrayList<>();
        this.consequents = new ArrayList<>();
    }

    // Getter & setter
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

    // Methods
    // Add a new premise
    public void addPremise(AttributeValue premise) {
        this.premises.add(premise);
    }

    // Add a new premise as first element
    public void addPremiseFirst(AttributeValue premise) {
        this.premises.add(0, premise);
    }

    // Remove a premise by index
    public void removePremise(int index) {
        this.premises.remove(index);
    }

    // Get a premise by index
    public AttributeValue getIndexPremise(int index) {
        return this.premises.get(index);
    }

    // Number of premises
    public int getNumPremises() {
        return this.premises.size();
    }

    // Add a new consequent
    public void addConsequent(AttributeValue consequent) {
        this.consequents.add(consequent);
    }

    // Add a new consequent as first element
    public void addConsequentFirst(AttributeValue consequent) {
        this.premises.add(0, consequent);
    }

    //Remove a consequent by index
    public void removeConsequent(int index) {
        this.consequents.remove(index);
    }

    // Get a consequent by index
    public AttributeValue getIndexConsequent(int index) {
        return this.consequents.get(index);
    }

    // Number of consequents
    public int getNumConsequents() {
        return this.consequents.size();
    }
    
    // Premise to string
    public String strPremise() {
        String msg = "";
        for(AttributeValue attribute : this.getPremises()) {
            msg += attribute.toString() + " ";
        }
        msg = msg.trim();
        return msg;
    }
    
    // Consequent to string
    public String strConsequent() {
        String msg = "";
        for(AttributeValue attribute : this.getConsequents()) {
            msg += attribute.toString() + " ";
        }
        msg = msg.trim();
        return msg;
    }
}