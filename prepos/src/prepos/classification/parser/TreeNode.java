package prepos.classification.parser;

import prepos.rules.AttributeValue;

/*
 * Author: Cristian Simioni
 * Last update: 10/15/2013
 * 
 * Changes:
 * Date         Author              Function            Description
 * -----------+-------------------+-------------------+------------------------
 * 10/15/2013 | Cristian Simioni  | -                 | - 
 */
public class TreeNode {

    // Atrributes
    private AttributeValue attributeValue;
    private int previousLevel;
    private boolean leaf;
    private float hit;
    private float miss;

    // Constructor
    public TreeNode(AttributeValue attributeValue) {
        this.leaf = false;
        this.attributeValue = attributeValue;
        this.previousLevel = -1;
        this.hit = 0.0f;
        this.miss = 0.0f;
    }

    // Getter & setter
    public AttributeValue getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(AttributeValue attributeValue) {
        this.attributeValue = attributeValue;
    }

    public int getPreviousLevel() {
        return previousLevel;
    }

    public void setPreviousLevel(int previousLevel) {
        this.previousLevel = previousLevel;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public float getHit() {
        return hit;
    }

    public void setHit(float hit) {
        this.hit = hit;
    }

    public float getMiss() {
        return miss;
    }

    public void setMiss(float miss) {
        this.miss = miss;
    }
}