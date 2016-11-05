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

    }

    /**
     * Start the OS Simulator.
     *
     * @param memory memory
     * @param timer value for timer interrupt.
     */
    public void start(int[] memory, int timer) {

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
        throw new UnsupportedOperationException();
    }
}
