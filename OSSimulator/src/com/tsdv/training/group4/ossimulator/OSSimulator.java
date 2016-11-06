package com.tsdv.training.group4.ossimulator;

import java.io.FileNotFoundException;
import java.io.IOException;

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
        //load program
        
        //get timer
        
        //start
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
        int[] memory = new int[Utils.MEMORY_SIZE];
        //create new file following fileName
        //create a array for memory
        
        //read line
            //if not empty line
                //slip line to get first element
                //
                //check first character of element
                    //if '.' then read loader to change the load address
                    //else paser to int and store to array
                    
        return memory;
    }
}
