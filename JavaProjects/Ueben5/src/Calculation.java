public class Calculation {
    public static void main(String[] args) {
        for (int a = 1; a <= 30; a++) {
            double squaredA = (int) Math.pow(a, 2);
            for (int b = 1; b <= 30; b++) {
                double squaredB = Math.pow(b, 2);
                int c = (int) Math.sqrt(squaredA + squaredB);
                if (Math.sqrt(squaredA + squaredB) <= 30 && Math.sqrt(squaredA + squaredB) % 1 == 0) System.out.println("a = " + a + " b = " + b + " c = " + c);
            }
        }
    }
}
