package Test.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TimerHandler {
    private Timer timer;

    public TimerHandler() {
        long startTime = System.currentTimeMillis();

        // Create a Swing Timer that triggers an action every second
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long currentTime = System.currentTimeMillis();
                long elapsedTime = (currentTime - startTime) / 1000;
                System.out.println("Seconds elapsed: " + elapsedTime);

                // Check if 1 minute (60 seconds) has elapsed
                if (elapsedTime == 60) {
                    System.out.println("Trigger activated! 1 minute has passed.");
                    // Perform your desired action here
                    stopTimer(); // Stop the timer
                }
            }
        });
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }
}
