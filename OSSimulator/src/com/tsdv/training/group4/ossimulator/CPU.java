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
    if(regAC != 0){
      int address = memory.read(regPC++);
      regPC = address;
    }else{
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
