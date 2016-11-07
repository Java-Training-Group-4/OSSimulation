package com.tsdv.training.group4.ossimulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            //load program
            int[] memory = loadProgram("program1.txt");
            //get timer
            
            //start
        } catch (SecurityException ex) {
            Logger.getLogger(OSSimulator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OSSimulator.class.getName()).log(Level.SEVERE, null, ex);
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
        
        //call cpu.run
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
        
        Pattern patternInstruction = Pattern.compile("^([0-9]+)");
        Pattern patternPeriod = Pattern.compile("^.([0-9]+)");
        int address = 0;
        
        while(scanner.hasNext()){
            //read line
            String line = scanner.nextLine();
            
            //check instruction
            Matcher matcherInstruction = patternInstruction.matcher(line);
            if(matcherInstruction.find()){
                String instruction = matcherInstruction.group(0);
                memory[address++] = Integer.parseInt(instruction);
            }else{
            //check period
                Matcher matcherPeriod = patternPeriod.matcher(line);
                if(matcherPeriod.find()){
                    String jumAddress = matcherPeriod.group(1);
                    address = Integer.parseInt(jumAddress);
                }
            }
        }
                    
        return memory;
    }
}
