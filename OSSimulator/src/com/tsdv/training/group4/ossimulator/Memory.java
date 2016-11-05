package com.tsdv.training.group4.ossimulator;

/**
 * Memory contain address of instruction to be executed.
 */
public class Memory {

    /**
     * Array store instructions to be executed.
     */
    private int[] mem;
    /**
     * <ol>Working mode of Memory. There are 2 types:<ol>
     * <li>User mode</li>
     * <li>System mode</li>
     */
    private int mode;

    /**
     * Default constructor.
     */
    public Memory() {

    }

    /**
     * Initialize memory.
     *
     * @param mem memory with instructions.
     */
    public void initialize(int[] mem) {
        throw new UnsupportedOperationException();
    }

    /**
     * Read value at address.
     *
     * @param address address
     * @return value.
     */
    public int read(int address) {
        throw new UnsupportedOperationException();
    }

    /**
     * Write data to memory.
     *
     * @param address address
     * @param data data value.
     */
    public void write(int address, int data) {
        throw new UnsupportedOperationException();
    }

    /**
     * Switch between user mode and system mode.
     */
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
