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
      this.isInterrupt = false;
      this.memory = new Memory();
      this.regAC = 0;
      this.regIR = 0;
      this.regPC = 0;
      this.regSP = 0;
      this.regX = 0;
      this.regY = 0;
    }

    /**
     * function run User program at address 0
     */
    public void run() {
      // declare 'count' variable store number of instruction is executed
      
      // loop instructions from user memory
      
        // load instruction by using fetchIR() function
        
        // increase value of PC register by 1 unit
      
        // execute instruction
      
        /**
         * check count == timer
         * If yes, switch mode to SYSTEM_MODE, set isInterrupt = true
         * and call interrupt() function 
         */
    }

    /**
     * function initialize memory of OS
     * @param mem Memory of OS
     */
    public void initialize(int[] mem) {
        // call initialize() function of memory
    }

    /**
     * function switch mode User stack to System stack and reverse
     */
    public void switchMode() {
      /**
       * check mode == USER_MODE switch to SYSTEM_MODE or reverse
       */
    }

    /**
     * 
     * @return Instruction code
     */
    public int fetchIR() {
      /**
       * get instruction from User memory with PC index
       */
      
      return 0;
    }

    /**
     * function execute instruction
     */
    public void executeInstruction() {
      /**
       * switch case: call corresponding function 
       */
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
    
    /**
     * function for instruction 11 - Add the value in Y to the AC
     */
    private void addY() {
      this.regAC += this.regY;
    }
    
    /**
     * function for instruction 12 - Subtract the value in X from the AC
     */
    private void subX() {
      this.regAC -= this.regX;
    }
    
    /**
     * function for instruction 13 - Subtract the value in Y from the AC
     */
    private void subY() {
      this.regAC -= this.regY;
    }
    
    /**
     * function for instruction 14 - Copy the value in the AC to X
     */
    private void copyToX() {
      this.regX = this.regAC;
    }
    
    /**
     * function for instruction 15 - Copy the value in X to the AC
     */
    private void copyFromX() {
      this.regAC = this.regX;
    }
    
    /**
     * function for instruction 16 - Copy the value in the AC to Y
     */
    private void copyToY() {
      this.regY = this.regAC;
    }
    
    /**
     * function for instruction 17 - Copy the value in Y to the AC
     */
    private void copyFromY() {
      this.regAC = this.regY;
    }
    
    /**
     * function for instruction 18 - Copy the value in AC to the SP
     */
    private void copyToSp() {
      this.regSP = this.regAC;
    }
    
    /**
     * function for instruction 19 - Copy the value in SP to the AC
     */
    private void copyFromSp() {
      this.regAC = this.regSP;
    }
    
    /**
     * function for instruction 15 - Jump to the address
     */
    private void jumpAddress() {
      int currentAddr = this.regPC;
      this.regPC = this.memory.read(currentAddr);
    }
    
    
}
