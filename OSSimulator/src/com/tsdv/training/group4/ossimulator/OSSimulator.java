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
      OSSimulator simulator = new OSSimulator();
      simulator.verifyInputParameters(args);
      // Get parameters
      String programFile = args[0];
      //load program
      int[] memory = simulator.loadProgram(programFile);
      // Get timer
      int timer = Integer.valueOf(args[1]);
      //start
      
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
   * @param timer value for timer intTimer.
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
  private int[] loadProgram(String fileName) throws FileNotFoundException, SecurityException, IOException {
    //create new file following fileName
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);
    //create a array for memory
    int[] memory = new int[Utils.MEMORY_SIZE];
    //create address
    int address = 0;
    
    //read file
    String programAttribute;
    String jumpAddress;
    while (scanner.hasNext()) {
      //read line
      String line = scanner.nextLine();

      //get program attribute
      programAttribute = getProgramAtrritube(line);
      if(!programAttribute.isEmpty()){
        memory[address++] = parseToInt(programAttribute);
      }else{
        //get jump address
        jumpAddress = getJumpAddress(line);
        if(!jumpAddress.isEmpty()){
          address = parseToInt(jumpAddress);
        }
        
      }
      
    }

    return memory;
  }

  /**
   * parse string to integer
   * @param value
   * @return integer of value or -1 if value is not number format
   */
  private int parseToInt(String value){
    int paseValue;
    try{
      paseValue = Integer.parseInt(value);
    }catch(NumberFormatException ex){
      paseValue = -1;
    }
    return paseValue;
  }
  /**
   * get program attribute
   * @param line string include program attribute
   * @return program attribute or empty if line doesn't include program attribute
   */
  private String getProgramAtrritube(String line) {
    String programAtrribute = "";
    Pattern patternInstruction = Pattern.compile(Utils.PROGRAM_ATTRIBUTE_PATTERN);
    
    Matcher matcherInstruction = patternInstruction.matcher(line);
    if (matcherInstruction.find()) {
      programAtrribute = matcherInstruction.group(0);
    }

    return programAtrribute;
  }

  /**
   * get jump address
   * @param line string include jump address
   * @return jump address or -1 if line doesn't include jumpAddress
   */
  private String getJumpAddress(String line) {
    String jumAddr = "";
    Pattern patternPeriod = Pattern.compile(Utils.PERIOD_PATTERN);
    //check period
    Matcher matcherPeriod = patternPeriod.matcher(line);
    if (matcherPeriod.find()) {
      jumAddr = matcherPeriod.group(0).substring(Utils.TIMER_SIGN.length());
    }
    return jumAddr;
  }

  /**
   * Verify input parameters.
   *
   * @param args input parameters
   */
  private void verifyInputParameters(String[] args) {
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
