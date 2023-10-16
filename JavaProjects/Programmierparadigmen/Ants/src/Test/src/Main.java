package Test.src;

import graphics.Display;

import java.lang.Thread;

public class Main {
    public static void main(String[] args) {
        //Display stuff
        System.setProperty("java.awt.headless", "false");
        //Set DISPLAY variable
        String[] command = {"sh", "-c", "export DISPLAY=:0"};
        // Start the process
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        simulation();
        simulation();
        simulation();
    }

    // create a new display frame and run the simulation for a set number of steps
    private static void simulation() {
        Field field = new Field(250, 200, 100, 20);
        field.printHillAndFoodSources();
        //field.printAnts();
        Display testDisp = new Display(4, field);
        testDisp.showFrame();

        for (int i = 0; i < 2000; i++) {
            field.update();
            testDisp.refresh();
            sleep(10);
        }
    }

    // sleep for t milliseconds
    private static void sleep(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


