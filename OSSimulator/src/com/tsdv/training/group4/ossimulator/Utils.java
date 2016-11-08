package com.tsdv.training.group4.ossimulator;

/**
 * Utility class.
 */
public class Utils {

  /**
   * Size of memory.
   */
  public static int MEMORY_SIZE = 2000;
  /**
   * Start index of User memory zone.
   */
  public static int USER_MEMORY_INDEX = 999;
  /**
   * Working mode of CPU - User mode.
   */
  public static int USER_MODE = 1;
  /**
   * Working mode of CPU - System mode.
   */
  public static int SYSTEM_MODE = 2;
  /**
   * Start address of timer interrupt.
   */
  public static int TIMER_INTERRUPT_ADDR = 1000;
  /**
   * Start address of system interrupt.
   */
  public static int SYSTEM_INTERRUPT_ADDR = 1500;
  /**
   * Instruction pattern.
   */
  public static String PROGRAM_ATTRIBUTE_PATTERN = "^[-]?[0-9]+";
  /**
   * Period Pattern.
   */
  public static String PERIOD_PATTERN = "^\\.[0-9]+";

  public static String TIMER_SIGN = ".";

  /**
   * Start point index of User stack
   */
  public static int START_USER_STACK_INDEX = 999;

  /**
   * Start point index of System stack
   */
  public static int START_SYSTEM_STACK_INDEX = 1999;
  
  /**
   * Error index out of range message
   */
  public static int[] MESSAGE_OUT_OF_RANGE = {
      1, 73, // I
      9, 2,
      1, 110, // n
      9, 2,
      1, 118, // v
      9, 2,
      1, 97, // a
      9, 2,
      1, 108, // l
      9, 2,
      1, 105, // i
      9, 2,
      1, 100, // d
      9, 2,
      1, 32, // _
      9, 2,
      1, 105, // i
      9, 2,
      1, 110, // n
      9, 2,
      1, 100, // d
      9, 2,
      1, 101, // e
      9, 2,
      1, 120, // x
      9, 2,
      1, 33, // !
      9, 2,
      1, 10, // \n
      9, 2,
      50 // END program
    };
  
  /**
   * Error Illegal Access message
   */
  public static int[] MESSAGE_ILLEGAL_ACCESS = {
      1, 65, // A
      9, 2,
      1, 99, // c
      9, 2,
      1, 99, // c
      9, 2,
      1, 101, // e
      9, 2,
      1, 115, // s
      9, 2,
      1, 115, // s
      9, 2,
      1, 32, // _
      9, 2,
      1, 101, // e
      9, 2,
      1, 114, // r
      9, 2,
      1, 114, // r
      9, 2,
      1, 111, // o
      9, 2,
      1, 114, // r
      9, 2,
      1, 33, // !
      9, 2,
      1, 10, // \n
      9, 2,
      50 // End program!
    };
}
