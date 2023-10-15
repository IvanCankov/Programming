import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String input = "jel.txt";
        String output = "kimaradst.txt";
        Solution sol = new Solution(input, output);
        sol.coordsOfEntry();
        sol.totalTimeElapsed();
        sol.maxSquare();
        sol.sumOfDist();
    }
}

class Solution {
    private final List<Entry> entries;

    public Solution(String input_file, String output_file) {
        entries = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(input_file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitLine = line.trim().split(" ");
                entries.add(new Entry(splitLine[0], splitLine[1], splitLine[2], splitLine[3], splitLine[4]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int elapsedBetween(int hour, int minute, int second) {
        return hour * 3600 + minute * 60 + second;
    }

    public int[] formattedTime(int seconds) {
        int[] time = new int[3];
        time[0] = seconds / 3600;           // hours
        time[1] = (seconds % 3600) / 60;    // minutes
        time[2] = (seconds % 3600) % 60;    // seconds
        return time;
    }

    public void coordsOfEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("2. feladat\nAdja meg a jel sorszámát! ");
        int number = scanner.nextInt() - 1;
        scanner.close();
        System.out.println("x=" + entries.get(number).getX() + " y=" + entries.get(number).getY());
    }

    public void totalTimeElapsed() {
        int seconds = elapsedBetween(entries.get(entries.size() - 1).getHour(), entries.get(entries.size() - 1).getMinute(), entries.get(entries.size() - 1).getSecond())
                - elapsedBetween(entries.get(0).getHour(), entries.get(0).getMinute(), entries.get(0).getSecond());
        int[] time = formattedTime(seconds);
        System.out.println("4. feladat\nIdőtartam: " + time[0] + ":" + time[1] + ":" + time[2]);
    }

    public void maxSquare() {
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        int max_x = Integer.MIN_VALUE;
        int max_y = Integer.MIN_VALUE;

        for (Entry entry : entries) {
            min_x = Math.min(entry.getX(), min_x);
            min_y = Math.min(entry.getY(), min_y);
            max_x = Math.max(entry.getX(), max_x);
            max_y = Math.max(entry.getY(), max_y);
        }
        System.out.println("5. feladat\nBal alsó: " + min_x + " " + min_y + ", jobb felső: " + max_x + " " + max_y);
    }

    public void sumOfDist() {
        double total_distance = 0.0;

        for (int i = 0; i < entries.size() - 1; i++) {
            double distance = Math.sqrt(Math.pow(entries.get(i).getX() - entries.get(i + 1).getX(), 2)
                    + Math.pow(entries.get(i).getY() - entries.get(i + 1).getY(), 2));
            total_distance += distance;
        }
        System.out.printf("6. feladat\nElmozdulás: %.3f egység\n", total_distance);
    }

    private static class Entry {
        private final int hour;
        private final int minute;
        private final int second;
        private final int x_coord;
        private final int y_coord;

        public Entry(String hour, String minute, String second, String x_coord, String y_coord) {
            this.hour = Integer.parseInt(hour);
            this.minute = Integer.parseInt(minute);
            this.second = Integer.parseInt(second);
            this.x_coord = Integer.parseInt(x_coord);
            this.y_coord = Integer.parseInt(y_coord);
        }

        public int getHour() {
            return hour;
        }

        public int getMinute() {
            return minute;
        }

        public int getSecond() {
            return second;
        }

        public int getX() {
            return x_coord;
        }

        public int getY() {
            return y_coord;
        }
    }
}