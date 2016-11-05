package com.tsdv.training.group4.ossimulator;

/**
 *
 */
public class Memory {

    private int[] mem;
    private int mode;

    public Memory() {

    }

    public void initialize(int[] mem) {
        throw new UnsupportedOperationException();
    }

    public int read(int address) {
        throw new UnsupportedOperationException();
    }

    public void write(int address, int data) {
        throw new UnsupportedOperationException();
    }

    public void switchMode() {
        throw new UnsupportedOperationException();
    }

    public int[] getMem() {
        return mem;
    }

    public int getMode() {
        return mode;
    }

    public void setMem(int[] mem) {
        this.mem = mem;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

}
