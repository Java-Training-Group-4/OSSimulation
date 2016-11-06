package com.tsdv.training.group4.ossimulator;

/**
 * CPU process
 */
public class CPU {
    /**
     * register PC
     */
    private int regPC;
    /**
     * register SP
     */
    private int regSP;
    /**
     * register IR
     */
    private int regIR;
    /**
     * register AC
     */
    private int regAC;
    /**
     * register X
     */
    private int regX;
    /**
     * register Y
     */
    private int regY;
    /**
     * number of instruction for a timer.
     */
    private int timer;
    /**
     * flag for interrupt processing
     */
    private boolean isInterrupt;
    /**
     * Memory of OS
     */
    private Memory memory;

    /**
     * Constructor function
     */
    public CPU() {
    }

    /**
     * function run User program at address 0
     */
    public void run() {
        throw new UnsupportedOperationException();
    }

    /**
     * function initialize memory of OS
     * @param mem Memory of OS
     */
    public void initialize(int[] mem) {
        throw new UnsupportedOperationException();
    }

    /**
     * function switch mode User stack to System stack and reverse
     */
    public void switchMode() {
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @return Instruction code
     */
    public int fetchIR() {
        throw new UnsupportedOperationException();
    }

    /**
     * function execute instruction
     */
    public void executeInstruction() {
        throw new UnsupportedOperationException();
    }

    /**
     * function interrupt processing
     */
    public void interrupt() {
        throw new UnsupportedOperationException();
    }
}
