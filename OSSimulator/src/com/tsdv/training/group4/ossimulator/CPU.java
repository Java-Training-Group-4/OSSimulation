package com.tsdv.training.group4.ossimulator;

/**
 *
 */
public class CPU {

    private int regPC;
    private int regSP;
    private int regIR;
    private int regAC;
    private int regX;
    private int regY;
    private Interrupt timerInterrupt;
    private Memory memory;

    public CPU() {
    }

    public void run() {
        throw new UnsupportedOperationException();
    }

    public void initialize(int[] mem) {
        throw new UnsupportedOperationException();
    }

    public void switchMode() {
        throw new UnsupportedOperationException();
    }

    public int fetchIR() {
        throw new UnsupportedOperationException();
    }

    public void executeInstruction() {
        throw new UnsupportedOperationException();
    }

    public void setTimer(int value) {
        throw new UnsupportedOperationException();
    }
}
