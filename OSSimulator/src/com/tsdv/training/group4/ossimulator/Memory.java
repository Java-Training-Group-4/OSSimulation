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
    this.mem = new int[Utils.MEMORY_SIZE];
    this.mode = Utils.USER_MODE;
  }

  /**
   * Initialize memory.
   *
   * @param mem memory with instructions.
   */
  public void initialize(int[] mem) {
    //
    if (mem == null) {
      throw new IllegalArgumentException("Memory is null");
    }
    if (mem.length < Utils.MEMORY_SIZE) {
      throw new IllegalArgumentException("Does not meet minimum requirement of memory");
    }
    if (mem.length > Utils.MEMORY_SIZE) {
      throw new IllegalArgumentException("Exceed maximum memory");
    }
    this.mem = mem;
  }

  /**
   * Read value at address.
   *
   * @param address address
   * @return value.
   */
  public int read(int address) {
    if (address < 0 || address >= Utils.MEMORY_SIZE) {
      throw new IndexOutOfBoundsException();
    }
    if (mode == Utils.USER_MODE && address > Utils.USER_MEMORY_INDEX) {
      throw new IllegalAccessError();
    }
    return mem[address];
  }

  /**
   * Write data to memory.
   *
   * @param address address
   * @param data data value.
   */
  public void write(int address, int data) {
    if (address < 0 || address >= Utils.MEMORY_SIZE) {
      throw new IndexOutOfBoundsException();
    }
    if (mode == Utils.USER_MODE && address > Utils.USER_MEMORY_INDEX) {
      throw new IllegalAccessError();
    }
    this.mem[address] = data;
  }

  /**
   * Switch between user mode and system mode.
   */
  public void switchMode() {
    if (mode == Utils.USER_MODE) {
      mode = Utils.SYSTEM_MODE;
    } else {
      mode = Utils.USER_MODE;
    }
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
