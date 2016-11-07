package com.tsdv.training.group4.ossimulator;

/**
 * Instruction set.
 */
public class Instruction {

    /**
     * Load the value into the AC.
     */
    public static final int LOAD_VALUE = 1;
    /**
     * Load the value at the address into the AC.
     */
    public static final int LOAD_ADDRESS = 2;
    /**
     * Load the value from the address found in the given address into the AC
     * (for example, if LoadInd 500, and 500 contains 100, then load from 100).
     *
     */
    public static final int LOAD_IND_ADDRESS = 3;
    /**
     * Load the value at (address+X) into the AC (for example, if LoadIdxX 500,
     * and X contains 10, then load from 510).
     *
     */
    public static final int LOAD_IDX_X_ADDRESS = 4;
    /**
     * Load the value at (address+Y) into the AC
     */
    public static final int LOAD_IDX_Y_ADDRESS = 5;
    /**
     * Load from (Sp+X) into the AC
     */
    public static final int LOAD_SP_X = 6;
    /**
     * Store the value in the AC into the address
     */
    public static final int STORE_ADDRESS = 7;
    /**
     * Gets a random int from 1 to 100 into the AC
     */
    public static final int GET = 8;
    /**
     * If port=1, writes AC as an int to the screen <br>
     * If port=2, writes AC as a char to the screen
     */
    public static final int PUT_PORT = 9;
    /**
     * Add the value in X to the AC
     */
    public static final int ADD_X = 10;
    /**
     * Add the value in Y to the AC
     */
    public static final int ADD_Y = 11;
    /**
     * Subtract the value in X from the AC
     */
    public static final int SUB_X = 12;
    /**
     * Subtract the value in Y from the AC
     */
    public static final int SUB_Y = 13;
    /**
     * Copy the value in the AC to X
     */
    public static final int COPY_TO_X = 14;
    /**
     * Copy the value in X to the AC
     */
    public static final int COPY_FROM_X = 15;
    /**
     * Copy the value in the AC to Y
     */
    public static final int COPY_TO_Y = 16;
    /**
     * Copy the value in Y to the AC
     */
    public static final int COPY_FROM_Y = 17;
    /**
     * Copy the value in AC to the SP
     */
    public static final int COPY_TO_SP = 18;
    /**
     * Copy the value in SP to the AC
     */
    public static final int COPY_FROM_SP = 19;
    /**
     * Jump to the address
     */
    public static final int JUMP_ADDRESS = 20;
    /**
     * Jump to the address only if the value in the AC is 0
     */
    public static final int JUMP_IF_EQUAL = 21;
    /**
     * Jump to the address only if the value in the AC is not 0
     */
    public static final int JUMP_IF_NOT_EQUAL = 22;
    /**
     * Push return address onto stack, jump to the address
     */
    public static final int CALL_ADDRESS = 23;
    /**
     * Pop return address from the stack, jump to the address
     */
    public static final int RET = 24;
    /**
     * Increment the value in X
     */
    public static final int INC_X = 25;
    /**
     * Decrement the value in X
     */
    public static final int DEC_X = 26;
    /**
     * Push AC onto stack
     */
    public static final int PUSH = 27;
    /**
     * Pop from stack into AC
     */
    public static final int POP = 28;
    /**
     * System interrupt - Set system mode, switch stack, push SP and PC, set new
     * SP and PC
     */
    public static final int INT = 29;
    /**
     * Restore registers, set user mode
     */
    public static final int IRET = 30;
    /**
     * End execution
     */
    public static final int END = 50;
}
