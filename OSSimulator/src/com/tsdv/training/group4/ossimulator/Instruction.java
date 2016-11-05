package com.tsdv.training.group4.ossimulator;

/**
 *
 * @author Manh Le
 */
public class Instruction {

    public static int LOAD_VALUE = 1;
    public static int LOAD_ADDRESS = 2;
    public static int LOAD_IND_ADDRESS = 3;
    public static int LOAD_IDX_X_ADDRESS = 4;
    public static int LOAD_IDX_Y_ADDRESS = 5;
    public static int LOAD_SP_X = 6;
    public static int STORE_ADDRESS = 7;
    public static int GET = 8;
    public static int PUT_PORT = 9;
    public static int ADD_X = 10;
    public static int ADD_Y = 11;
    public static int SUB_X = 12;
    public static int SUB_Y = 13;
    public static int COPY_TO_X = 14;
    public static int COPY_FROM_X = 15;
    public static int COPY_TO_Y = 16;
    public static int COPY_FROM_Y = 17;
    public static int COPY_TO_SP = 18;
    public static int COPY_FROM_SP = 19;
    public static int JUMP_ADDRESS = 20;
    public static int JUMP_IF_EQUAL = 21;
    public static int JUMP_IF_NOT_EQUAL = 22;
    public static int CALL_ADDRESS = 23;
    public static int RET = 24;
    public static int INC_X = 25;
    public static int DEC_X = 26;
    public static int PUSH = 27;
    public static int POP = 28;
    public static int INT = 29;
    public static int IRET = 30;
    public static int END = 50;
}
