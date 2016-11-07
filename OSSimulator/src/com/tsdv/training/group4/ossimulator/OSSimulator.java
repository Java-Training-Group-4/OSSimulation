package com.tsdv.training.group4.ossimulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Entry point of OS Simulator.
 */
public class OSSimulator {

  /**
   * CPU.
   */
  private CPU cpu;

  public OSSimulator() {
    cpu = new CPU();
  }

  public static void main(String[] args) {
    try {
//      verifyInputParameters(args);
      // Get parameters
//      String programFile = args[0];
      String programFile = "data/program5.txt";
      //load program
      int[] memory = loadProgram(programFile);
      // Get timer
//      int timer = Integer.valueOf(args[1]);
      int timer = 5;
      //start
      OSSimulator simulator = new OSSimulator();
      simulator.start(memory, timer);

    } catch (NumberFormatException ex) {
      throw new IllegalArgumentException("Timer value should be positive integer and greater than 0.");
    } catch (IllegalArgumentException ex) {
      System.err.println(ex.getMessage());
    } catch (FileNotFoundException ex) {
      System.err.println("File not found!");
    } catch (SecurityException ex) {
      System.err.println("Access deny!");
    } catch (IOException ex) {
      System.err.println("Error while reading file");
    }
  }

  /**
   * Start the OS Simulator.
   *
   * @param memory memory
   * @param timer value for timer interrupt.
   */
  public void start(int[] memory, int timer) {
    //set memory by cpu.initialize
    cpu.setTimer(timer);
    cpu.initialize(memory);
    //call cpu.run
    cpu.run();
  }

  /**
   * Read program instructions from file.
   *
   * @param fileName File name
   * @return instruction set.
   * @throws FileNotFoundException File not found
   * @throws SecurityException Access deny
   * @throws IOException IO Exception
   */
  private static int[] loadProgram(String fileName) throws FileNotFoundException, SecurityException, IOException {
    //create new file following fileName
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);
    //create a array for memory
    int[] memory = new int[Utils.MEMORY_SIZE];
    Pattern patternInstruction = Pattern.compile(Utils.INSTRUCTION_PATTERN);
    Pattern patternPeriod = Pattern.compile(Utils.PERIOD_PATTERN);
    int address = 0;

    while (scanner.hasNext()) {
      //read line
      String line = scanner.nextLine();

      //check instruction
      Matcher matcherInstruction = patternInstruction.matcher(line);
      if (matcherInstruction.find()) {
        String instruction = matcherInstruction.group(0);
        memory[address++] = Integer.parseInt(instruction);
      } else {
        //check period
        Matcher matcherPeriod = patternPeriod.matcher(line);
        if (matcherPeriod.find()) {
          String jumAddress = matcherPeriod.group(0).substring(Utils.TIMER_SIGN.length());
          address = Integer.parseInt(jumAddress);
        }
      }
    }

    return memory;
  }

  /**
   * Verify input parameters.
   *
   * @param args input parameters
   */
  private static void verifyInputParameters(String[] args) {
    // Require 2 parameters
    if (args.length < 2) {
      throw new IllegalArgumentException("Program require 2 parameter as follow: <Program file> <timer value>");
    }

    // Program file is not empty.
    if (args[0].isEmpty()) {
      throw new IllegalArgumentException("Program file is empty");
    }
    int timer = Integer.valueOf(args[1]);
    // Timer <= 0
    if (timer <= 0) {
      throw new IllegalArgumentException("Timer value should be positive integer and greater than 0.");
    }
  }
}
