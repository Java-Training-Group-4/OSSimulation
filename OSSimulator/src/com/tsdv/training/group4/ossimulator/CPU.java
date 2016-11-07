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
  }

  /**
   * function run User program at address 0
   */
  public void run() {
    throw new UnsupportedOperationException();
  }

  /**
   * function initialize memory of OS
   *
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
   * Jump to the address only if the value in the AC is zero
   */
  private void jumpIfEquealAddr() {
    //if ac==0 then read address at pc and pc = address
    //else pc++
  }

  /**
   * Jump to the address only if the value in the AC is not zero
   */
  private void jumpIfNotEquealAddr() {
    //if ac != 0 then read address at pc and pc = address
    //else pc++
  }

  /**
   * Push return address onto stack, jump to the address
   */
  private void callAddr() {
    //read address at pc
    //wriete return address at sp
    //jump to the address
  }

  /**
   * Pop return address from the stack, jump to the address
   */
  private void ret() {
    //read return address at sp
    //jump to the address
  }

  /**
   * Increment the value in X
   */
  private void incX() {
    //increment the value in X
  }

  /**
   * Decrement the value in X
   */
  private void decX() {
    //Decrement the value in X
  }

  /**
   * Push AC onto stack
   */
  private void push() {
    //write ac to memory at sp
  }

  /**
   * Pop from stack into AC
   */
  private void pop() {
    //read value at sp
    //assign value to ac
  }

  /**
   * 29.Set system mode, switch stack, push SP and PC, set new SP and PC
   */
  private void intSystem() {
    //set system mode
    //save tmpSP = sp, tmpPC = pc
    //switch stack
    //push tmpSP, tmpPC to system stack
    //set new sp, pc
  }

  /**
   * Restore registers, set user mode
   */
  private void iret() {
    //pop from stack into sp, pc
    //set user mode
  }

  /**
   * End execution
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
