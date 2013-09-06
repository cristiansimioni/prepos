/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prepos.core;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian
 */
public class LoadBar implements Runnable {

    private int maxValue;
    private int currentValue;

    public LoadBar(int maxValue) {
        this.maxValue = maxValue;
        this.currentValue = 0;
        Shared.getInstance().getJbProgressStatus().setStringPainted(true);
        Shared.getInstance().getJbProgressStatus().setMaximum(maxValue);
    }

    public void update(int value) {
        currentValue = value;
    }

    @Override
    public void run() {
        
        Shared.getInstance().getJbProgressStatus().setValue(currentValue);
    }
}