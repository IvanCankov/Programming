public class Maximum {
    public static void main(String[] args){
        System.out.println(maximumOfThree(72435,4562,254356));
        System.out.println(maximumOfFour(123,435,234654,242));
        System.out.println(maximum(new int[]{123,546,23423,6546,12123,75675,234,645324,56456546}));
    }
    static int maximumOfThree(int a, int b, int c) {
        int[] elements = {a, b, c};
        int length = elements.length;

        for (int i = 0; i < length - 1; i++) {
            // Search the smallest element in the remaining array
            int minPos = i;
            int min = elements[minPos];
            for (int j = i + 1; j < length; j++) {
                if (elements[j] < min) {
                    minPos = j;
                    min = elements[minPos];
                }
            }

            // Swap min with element at pos i
            if (minPos != i) {
                elements[minPos] = elements[i];
                elements[i] = min;
            }
        }
        return elements[length - 1];
    }

    static int maximumOfFour(int a, int b, int c, int d) {
        int[] elements = {a, b, c, d};
        int length = elements.length;

        for (int i = 0; i < length - 1; i++) {
            // Search the smallest element in the remaining array
            int minPos = i;
            int min = elements[minPos];
            for (int j = i + 1; j < length; j++) {
                if (elements[j] < min) {
                    minPos = j;
                    min = elements[minPos];
                }
            }

            // Swap min with element at pos i
            if (minPos != i) {
                elements[minPos] = elements[i];
                elements[i] = min;
            }
        }
        return elements[length - 1];
    }

    static int maximum(int[] elements) {
        int length = elements.length;

        for (int i = 0; i < length - 1; i++) {
            // Search the smallest element in the remaining array
            int minPos = i;
            int min = elements[minPos];
            for (int j = i + 1; j < length; j++) {
                if (elements[j] < min) {
                    minPos = j;
                    min = elements[minPos];
                }
            }

            // Swap min with element at pos i
            if (minPos != i) {
                elements[minPos] = elements[i];
                elements[i] = min;
            }
        }
        return elements[length - 1];
    }
}
