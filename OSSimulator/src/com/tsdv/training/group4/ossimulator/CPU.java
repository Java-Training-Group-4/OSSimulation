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
        //enable isInterrupt
        //store cp,sp to user stack
        //assign cp = 1000
        //get sp from system stack
        //set system mode
    }
    
    /**
     * Jump to the address only if the value in the AC is zero
     */
    private void jumpIfEquealAddr(){
        //if ac==0 then read address at pc and pc = address
        //else pc++
    }
    /**
     * Jump to the address only if the value in the AC is not zero
     */
    private void jumpIfNotEquealAddr(){
        //if ac != 0 then read address at pc and pc = address
        //else pc++
    }
    /**
     * Push return address onto stack, jump to the address
     */
    private void callAddr(){
        //read address at pc
        //wriete return address at sp
        //jump to the address
    }
    /**
     * Pop return address from the stack, jump to the address
     */
    private void ret(){
        //read return address at sp
        //jump to the address
    }
    /**
     * Increment the value in X
     */
    private void incX(){
        //increment the value in X
    }
    /**
     * Decrement the value in X
     */
    private void decX(){
        //Decrement the value in X
    }
    /**
     * Push AC onto stack
     */
    private void push(){
        //write ac to memory at sp
    }
    /**
     * Pop from stack into AC
     */
    private void pop(){
        //read value at sp
        //assign value to ac
    }
    /**
     * 29.Set system mode, switch stack, push SP and PC, set new SP and PC
     */
    private void intSystem(){
        //set system mode
        //save tmpSP = sp, tmpPC = pc
        //switch stack
        //push tmpSP, tmpPC to system stack
        //set new sp, pc
    }
    /**
     * Restore registers, set user mode
     */
    private void iret(){
        //pop from stack into sp, pc
        //set user mode
    }
    /**
     * End execution
     */
    private void end(){
        
    }
}
