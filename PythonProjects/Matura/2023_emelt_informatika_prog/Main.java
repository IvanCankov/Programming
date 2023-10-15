import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Pixel {
    private int red;
    private int green;
    private int blue;

    public Pixel(String red, String green, String blue) {
        this.red = Integer.parseInt(red);
        this.green = Integer.parseInt(green);
        this.blue = Integer.parseInt(blue);
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}

class Picture {
    private List<List<Pixel>> picture;
    private int countBright;
    private List<Pixel> darkestPixel;
    private int darkestSum;

    public Picture(String inputFile, String outputFile) {
        picture = new ArrayList<>();
        countBright = 0;
        darkestPixel = new ArrayList<>();
        darkestSum = 3 * 255;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<Pixel> pixels = new ArrayList<>();
                String[] colors = line.trim().split("\\s+");

                for (int i = 0; i < colors.length; i += 3) {
                    int r = Integer.parseInt(colors[i]);
                    int g = Integer.parseInt(colors[i + 1]);
                    int b = Integer.parseInt(colors[i + 2]);

                    if (isBright(r, g, b)) {
                        countBright++;
                    }
                    if (sumEquals(darkestSum, r, g, b)) {
                        darkestPixel.add(new Pixel(String.valueOf(r), String.valueOf(g), String.valueOf(b)));
                    }
                    if (isDarker(darkestSum, r, g, b)) {
                        darkestPixel.clear();
                        darkestPixel.add(new Pixel(String.valueOf(r), String.valueOf(g), String.valueOf(b)));
                        darkestSum = r + g + b;
                    }
                    pixels.add(new Pixel(String.valueOf(r), String.valueOf(g), String.valueOf(b)));
                }
                picture.add(pixels);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isBright(int r, int g, int b) {
        return r + g + b > 600;
    }

    public Pixel getPixel(int x, int y) {
        return picture.get(x - 1).get(y - 1);
    }

    public void getDarkestSum() {
        System.out.println("4. feladat:");
        System.out.println("A legsötétebb pont RGB összege: " + darkestSum);
    }

    public void getDarkestPixel() {
        System.out.println("A legsötétebb pixelek színe:");
        for (Pixel pixel : darkestPixel) {
            System.out.println("RGB(" + pixel.getRed() + ", " + pixel.getGreen() + ", " + pixel.getBlue() + ")");
        }
    }

    public boolean isDarker(int target, int r, int g, int b) {
        return r + g + b < target;
    }

    public boolean sumEquals(int target, int r, int g, int b) {
        return target == r + g + b;
    }

    public void colorsAt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("2. feladat:");
        System.out.println("Kérem egy képpont adatait!");
        System.out.print("Sor: ");
        int x = scanner.nextInt();
        System.out.print("Oszlop: ");
        int y = scanner.nextInt();
        Pixel pixel = getPixel(x, y);
        System.out.println("A képpont színe RGB(" + pixel.getRed() + ", " + pixel.getGreen() + ", " + pixel.getBlue() + ")");
    }

    public void getCountOfBright() {
        System.out.println("3. feladat:");
        System.out.println("A világos képpontok száma: " + countBright);
    }

    // NOTE: the functions below aren't accurate -> refer to exercises 5 and 6
    public boolean border(int row, int blue1, int blue2) {
        return Math.abs(blue1 - blue2) >= 10;
    }

    public void objectStartAndEnd() {
        int start = -1;
        int end = -1;
        for (int i = 0; i < picture.size(); i++) {
            for (int j = 1; j < i; j++) {
                if (border(i, picture.get(i).get(j).getBlue(), picture.get(i).get(j - 1).getBlue())) {
                    end = i;
                }
                if (border(i, picture.get(i).get(j).getBlue(), picture.get(i).get(j - 1).getBlue()) && start == -1) {
                    start = i;
                }
            }
        }
        System.out.println("6. feladat:");
        System.out.println("A felhő legfelső sora: " + start);
        System.out.println("A felhő legalsó sora: " + end);
    }
}

public class Main {
    public static void main(String[] args) {
        String inputFile = "kep.txt";
        String outputFile = "";
        Picture pic = new Picture(inputFile, outputFile);
        pic.colorsAt();
        pic.getCountOfBright();
        pic.getDarkestSum();
        pic.getDarkestPixel();
        pic.objectStartAndEnd();
    }
}
