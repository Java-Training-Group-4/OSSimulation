package com.tsdv.training.group4.ossimulator;

/**
 * Timer class.<br>
 * A timer will interrupt the processor after every X instruction,<br>
 * where X is a command-line parameter.
 */
public class TimerInterrupt implements Interrupt {
    /**
     * counter executed instruction.
     */
    private int counter;
    /**
     * number of instruction for a timer.
     */
    private int nInstruction;

    /**
     * Constructor.
     * @param nInstruction number of instruction for a timer.
     */
    public TimerInterrupt(int nInstruction) {
        this.nInstruction = nInstruction;
        this.counter = 0;
    }

    /**
     * interrupt procession for timer.
     */
    @Override
    public void interrupt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * get number of instruction for a timer.
     * @return number of instruction.
     */
    public int getNInstruction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * set number of instruction for a timer.
     * @param nInstruction number of instruction.
     */
    public void setNInstruction(int nInstruction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * get number of executed instruction.
     * @return number of executed instruction.
     */
    public int getCounter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * set number of executed instruction.
     * @param counter number of executed instruction.
     */
    public void setCounter(int counter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
