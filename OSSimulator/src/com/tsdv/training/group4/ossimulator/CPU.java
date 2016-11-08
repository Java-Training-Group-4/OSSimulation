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
   * number of instruction for a timer
   */
  private int timer;
  /**
   * flag for intTimer processing
   */
  private boolean interrupt;

  /**
   * flag for ending program
   */
  private boolean terminate;

  /**
   * random object
   */
  Random rnd = new Random();

  /**
   * Memory of OS
   */
  private Memory memory;

  /**
   * User stack point index for User stack
   */
  private int userSP;

  /**
   * System stack point index for System stack
   */
  private int systemSP;

  /**
   * Constructor function
   */
  public CPU() {
    this.interrupt = false;
    this.memory = new Memory();
    this.userSP = Utils.START_USER_STACK_INDEX;
    this.systemSP = Utils.START_SYSTEM_STACK_INDEX;
    this.regAC = 0;
    this.regIR = 0;
    this.regPC = 0;
    this.regSP = userSP;
    this.regX = 0;
    this.regY = 0;
  }

  /**
   * function run User program at address 0
   */
  public void run() {
    // declare 'count' variable store number of instruction is executed
    int count = 0;
    // loop instructions from user memory
    while (!isTerminate()) {
      // load instruction by using fetchIR() function
      fetchIR();

      //increase count if user program processing
      if (!isInterrupt()) {
        count++;
      }
      // execute instruction
      executeInstruction();

      /* check count == timer If yes, switch mode to SYSTEM_MODE, set isInterrupt = true and call
       * intTimer() function
       */
      if (count == this.timer) {
        intTimer();
        count = 0;
      }
    }
  }

  /**
   * function initialize memory of OS
   *
   * @param mem Memory of OS
   */
  public void initialize(int[] mem) {
    // call initialize() function of memory
    this.memory.initialize(mem);
  }

  /**
   * function switch mode User stack to System stack and reverse
   */
  public void switchMode() {
    /*
     * check mode == USER_MODE switch to SYSTEM_MODE or reverse
     */
    memory.switchMode();
  }

  /**
   *
   * function fetch instruction into register IR
   */
  public void fetchIR() {
    /*
     * get instruction from User memory with PC index
     */
    this.regIR = this.memory.read(this.regPC++);
  }

  /**
   * function execute instruction
   */
  public void executeInstruction() {

    // switch case: call corresponding function
    try {
      switch (this.regIR) {
        case Instruction.LOAD_VALUE:
          loadValue();
          break;
        case Instruction.LOAD_ADDRESS:
          loadAddr();
          break;
        case Instruction.LOAD_IND_ADDRESS:
          loadIndAddr();
          break;
        case Instruction.LOAD_IDX_X_ADDRESS:
          loadIdxXAddr();
          break;
        case Instruction.LOAD_IDX_Y_ADDRESS:
          loadIdxYAddr();
          break;
        case Instruction.LOAD_SP_X:
          loadSpX();
          break;
        case Instruction.STORE_ADDRESS:
          storeAddr();
          break;
        case Instruction.GET:
          get();
          break;
        case Instruction.PUT_PORT:
          put();
          break;
        case Instruction.ADD_X:
          addX();
          break;
        case Instruction.ADD_Y:
          addY();
          break;
        case Instruction.SUB_X:
          subX();
          break;
        case Instruction.SUB_Y:
          subY();
          break;
        case Instruction.COPY_TO_X:
          copyToX();
          break;
        case Instruction.COPY_FROM_X:
          copyFromX();
          break;
        case Instruction.COPY_TO_Y:
          copyToY();
          break;
        case Instruction.COPY_FROM_Y:
          copyFromY();
          break;
        case Instruction.COPY_FROM_SP:
          copyFromSp();
          break;
        case Instruction.COPY_TO_SP:
          copyToSp();
          break;
        case Instruction.JUMP_ADDRESS:
          jumpAddress();
          break;
        case Instruction.JUMP_IF_EQUAL:
          jumpIfEquealAddr();
          break;
        case Instruction.JUMP_IF_NOT_EQUAL:
          jumpIfNotEquealAddr();
          break;
        case Instruction.CALL_ADDRESS:
          callAddr();
          break;
        case Instruction.RET:
          ret();
        case Instruction.INC_X:
          incX();
          break;
        case Instruction.DEC_X:
          decX();
          break;
        case Instruction.PUSH:
          push();
          break;
        case Instruction.POP:
          pop();
          break;
        case Instruction.INT:
          intSystem();
          break;
        case Instruction.IRET:
          iret();
          break;
        case Instruction.END:
          end();
          break;
        default:
          break;
      }
    } catch (IllegalAccessError ex) {
      //print "Invalid access to memory"
      printMessage(Utils.MESSAGE_ILLEGAL_ACCESS);
    } catch (IndexOutOfBoundsException ex) {
      //print "Index out of range"
      printMessage(Utils.MESSAGE_OUT_OF_RANGE);
    }
  }

  /**
   * function intTimer processing
   */
  public void intTimer() {
    // check other intTimer is enabled
    if (!isInterrupt()) {
      // set interrupt = true
      setInterrupt(true);

      //set system mode
      switchMode();
      // switch stack
      switchToSystemStack();
      //store PC,SP to system stack
      systemSP = storeRegister(systemSP);

      //set new sp, pc
      setNewPcSPRegister(Utils.TIMER_INTERRUPT_ADDR, systemSP);

      //check timer program
      if (memory.read(Utils.TIMER_INTERRUPT_ADDR) == 0) {
        iret();
      }
    }
  }

  /**
   * switch to system stack
   */
  private void switchToSystemStack() {
    //save current stack point for user stack point
    userSP = this.regSP;
  }

  /**
   * store register to stack
   *
   * @param stackPoint stack point of stack
   * @return stack point after store register
   */
  private int storeRegister(int stackPoint) {
    this.memory.write(stackPoint--, this.regY);
    this.memory.write(stackPoint--, this.regX);
    this.memory.write(stackPoint--, this.regAC);
    this.memory.write(stackPoint--, this.regSP);
    this.memory.write(stackPoint--, this.regPC);

    return stackPoint;
  }

  /**
   * Set timer for intTimer.
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
    int returnAddress = memory.read(++regSP);
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
    regAC = memory.read(++regSP);
  }

  /**
   * 29. Set system mode, switch stack, push SP and PC, set new SP and PC
   */
  private void intSystem() {
    if (!isInterrupt()) {
      // set interrupt = true
      setInterrupt(true);

      //set system mode
      switchMode();
      //switch stack
      switchToSystemStack();
      //push tmpSP, tmpPC to system stack
      systemSP = storeRegister(systemSP);

      //set new sp, pc
      setNewPcSPRegister(Utils.SYSTEM_INTERRUPT_ADDR, systemSP);

      //check timer program
      if (memory.read(Utils.SYSTEM_INTERRUPT_ADDR) == 0) {
        iret();
      }
    }
  }

  /**
   * reset value for PC, SP registers
   *
   * @param pc PC register
   * @param sp SP register
   */
  private void setNewPcSPRegister(int pc, int sp) {
    regPC = pc;
    regSP = sp;
  }

  /**
   * 30. Restore registers, set user mode
   */
  private void iret() {
    // set interrupt = false
    setInterrupt(false);

    //switch stack
    switchToUserStack();
    //pop from stack into sp, pc
    systemSP = restoreRegisterFromStack(systemSP);
    //set user mode
    switchMode();
  }

  /**
   * switch to user stack
   */
  private void switchToUserStack() {
    //save current stack point to system stack point
    this.systemSP = this.regSP;
  }

  /**
   * restore register from stack
   *
   * @param stackPoint stack point of current stack
   * @return stack point after restore
   */
  private int restoreRegisterFromStack(int stackPoint) {
    regPC = memory.read(++stackPoint);
    regSP = memory.read(++stackPoint);
    regAC = memory.read(++stackPoint);
    regX = memory.read(++stackPoint);
    regY = memory.read(++stackPoint);

    return stackPoint;
  }

  /**
   * 50. End execution
   */
  private void end() {
    setTerminate(true);
  }

  /**
   * Print number to screen.
   *
   * @param data number
   */
  private void printNumber(int data) {
    System.out.print(data);
  }

  /**
   * Print character from number code.
   *
   * @param data number
   */
  private void printCharacter(int data) {
    System.out.print(Character.toChars(data));
  }

  /**
   * print message following instructions array
   *
   * @param instructions include message encode
   */
  private void printMessage(int[] instructions) {
    //write system intTimer program
    writeInterruptProgram(Utils.SYSTEM_INTERRUPT_ADDR, instructions);
    //call system intTimer
    intSystem();
    //execute
    run();
  }

  /**
   * write interrupt program to system memory
   *
   * @param interruptAddr interrupt address
   * @param instructions interrupt program
   */
  private void writeInterruptProgram(int interruptAddr, int[] instructions) {
    //switch to system mode to write intTimer program if current mode is user mode
    boolean isSwitch = false;
    if (memory.getMode() == Utils.USER_MODE) {
      switchMode();
      isSwitch = true;
    }

    //write message to system intTimer memory 
    for (int i = 0; i < instructions.length; i++) {
      memory.write(interruptAddr + i, instructions[i]);
    }

    //switch to mode before call this function
    if (isSwitch) {
      switchMode();
    }
  }

  public void setInterrupt(boolean interrupt) {
    this.interrupt = interrupt;
  }

  public boolean isInterrupt() {
    return interrupt;
  }

  public void setTerminate(boolean terminate) {
    this.terminate = terminate;
  }

  public boolean isTerminate() {
    return terminate;
  }
}
