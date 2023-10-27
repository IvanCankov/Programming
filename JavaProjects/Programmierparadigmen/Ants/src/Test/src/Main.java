package Test.src;

import Test.src.Field;
import graphics.Display;
import graphics.DrawData;
//import Test.src.test.BaseTests;

import java.io.IOException;
import java.lang.Thread;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //BaseTests.moveSearchTest();
        //BaseTests.moveDiscoverTest();
        graphicSimulation();
    }

    private static void graphicSimulation() throws IOException, InterruptedException {
        System.setProperty("java.awt.headless", "false");
        //Set DISPLAY variable
        String[] command = {"sh", "-c", "export DISPLAY=:0"};
        // Start the process
        try {
            //Process process = Runtime.getRuntime().exec(command);
            //process.waitFor();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        simulation();
        //simulation();
        //simulation();
    }
    // create a new display frame and run the simulation for a set number of steps
    private static void simulation() {
        Field field = new Field(250, 200, 50, 50);
        //field.printHillAndFoodSources();
        //field.printAnts();
        DrawData drawData = new DrawData(field);
        Display testDisp = new Display(4, drawData);
        testDisp.showFrame();

        for (int i = 0; i < 20000; i++) {
            field.update();
            drawData.update();
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


