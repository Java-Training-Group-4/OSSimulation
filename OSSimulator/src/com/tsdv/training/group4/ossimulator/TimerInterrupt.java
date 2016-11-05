package com.tsdv.training.group4.ossimulator;

/**
 *
 */
public class TimerInterrupt implements Interrupt {

    private int counter;
    private int timer;

    public TimerInterrupt() {
    }

    @Override
    public void interrupt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
