package com.tsdv.training.group4.ossimulator;

import java.util.Random;

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
     * check count == timer If yes, switch mode to SYSTEM_MODE, set isInterrupt = true and call
     * interrupt() function
     */
  }

  /**
   * function initialize memory of OS
   *
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
   * Set timer for interrupt.
   *
   * @param value timer value.
   */
  public void setTimer(int value) {
    this.timer = value;
  }

  /**
   * Load the value into the AC
   */
  private void loadValue() {
    regAC = memory.read(regPC++);
  }

  /**
   * Load the value at the address into the AC.
   */
  private void loadAddr() {
    int address = memory.read(regPC++);
    regAC = memory.read(address);
  }

  /**
   * Load the value from the address found in the given address into the AC (for example, if LoadInd
   * 500, and 500 contains 100, then load from 100).
   *
   */
  private void loadIndAddr() {
    int value = memory.read(regPC++);
    int address = memory.read(value);
    regAC = memory.read(address);
  }

  /**
   * Load the value at (address+X) into the AC (for example, if LoadIdxX 500, and X contains 10,
   * then load from 510).
   *
   */
  private void loadIdxXAddr() {
    int address = memory.read(regPC++);
    regAC = memory.read(address + regX);
  }

  /**
   * Load the value at (address+Y) into the AC
   */
  private void loadIdxYAddr() {
    int address = memory.read(regPC++);
    regAC = memory.read(address + regY);
  }

  /**
   * Load from (Sp+X) into the AC
   */
  private void loadSpX() {
    regAC = memory.read(regSP + regX);
  }

  /**
   * Store the value in the AC into the address
   */
  private void storeAddr() {
    int address = memory.read(regPC++);
    memory.write(address, regAC);
  }

  /**
   * Gets a random int from 1 to 100 into the AC
   */
  private void get() {
    Random rnd = new Random();
    int value = 1 + rnd.nextInt(100);
    regAC = value;
  }

  /**
   * If port=1, writes AC as an int to the screen <br>
   * If port=2, writes AC as a char to the screen
   */
  private void put() {
    int port = memory.read(regPC++);
    if (port == 1) {
      printNumber(regAC);
    } else if (port == 2) {
      printCharacter(regAC);
    }
  }

  /**
   * Add the value in X to the AC
   */
  private void addX() {
    regAC += regX;
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

  /**
   * 21. Jump to the address only if the value in the AC is zero
   */
  private void jumpIfEquealAddr() {
    //if ac==0 then read address at pc and pc = address
    if (regAC == 0) {
      int address = memory.read(regPC++);
      regPC = address;
    } else {
      //else pc++
      regPC++;
    }
  }

  /**
   * 22. Jump to the address only if the value in the AC is not zero
   */
  private void jumpIfNotEquealAddr() {
    //if ac != 0 then read address at pc and pc = address
    if (regAC != 0) {
      int address = memory.read(regPC++);
      regPC = address;
    } else {
      //else pc++
      regPC++;
    }
  }

  /**
   * 23. Push return address onto stack, jump to the address
   */
  private void callAddr() {
    //read address at pc
    int address = memory.read(regPC++);
    //wriete return address at sp
    memory.write(regSP--, regPC);
    //jump to the address
    regPC = address;
  }

  /**
   * 24. Pop return address from the stack, jump to the address
   */
  private void ret() {
    //read return address at sp
    int returnAddress = memory.read(regSP++);
    //jump to the address
    regPC = returnAddress;
  }

  /**
   * 25. Increment the value in X
   */
  private void incX() {
    //increment the value in X
    regX += 1;
  }

  /**
   * 26. Decrement the value in X
   */
  private void decX() {
    //Decrement the value in X
    regX -= 1;
  }

  /**
   * 27. Push AC onto stack
   */
  private void push() {
    //write ac to memory at sp
    memory.write(regSP--, regAC);
  }

  /**
   * 28. Pop from stack into AC
   */
  private void pop() {
    //read value at sp then assign value to ac
    regAC = memory.read(regSP++);
  }

  /**
   * 29. Set system mode, switch stack, push SP and PC, set new SP and PC
   */
  private void intSystem() {
    //set system mode
    switchMode();
    //save tmpSP = sp, tmpPC = pc
    int tmpSp = regSP;
    int tmpPc = regPC;
    //switch stack
    //set new sp, pc
    regPC = Utils.SYSTEM_INTERRUPT_ADDR;
    regSP = Utils.MEMORY_SIZE - 1;
    //push tmpSP, tmpPC to system stack
    memory.write(regSP--, tmpSp);
    memory.write(regSP--, tmpPc);
  }

  /**
   * 30. Restore registers, set user mode
   */
  private void iret() {
    //pop from stack into sp, pc
    regPC = memory.read(regSP++);
    regSP = memory.read(regSP);
    //set user mode
    switchMode();
  }

  /**
   * 50. End execution
   */
  private void end() {

  }

  /**
   * Print number to screen.
   *
   * @param data number
   */
  private void printNumber(int data) {
    System.out.println(data);
  }

  /**
   * Print character from number code.
   *
   * @param data number
   */
  private void printCharacter(int data) {
    System.out.println(Character.toChars(data));
  }
}
