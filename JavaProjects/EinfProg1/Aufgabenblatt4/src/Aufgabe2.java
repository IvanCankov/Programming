/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        int[] integerArray = {6, 1, 8, 2, 5, 3, 4, 7, 9, 0};
        int[] modSixArray = {6 , 12, 18, 24, 30, 36, 42, 48, 54, 60, 66, 72};
        int[] theSecondComingOfIntegerArray = {7, 3, 2, 7, 6, 7, 7, 8, 9, 5};
        int[] numbersWithLoop = new int[11];

        hashBetween(integerArray);
        modNineAndSix(modSixArray);
        printArray(modSixArray);
        printArray(minusOnes(theSecondComingOfIntegerArray));
        fillArray(numbersWithLoop);

        System.out.print("for-schleife: ");
        for (int i = numbersWithLoop.length - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.print(numbersWithLoop[i]);
                break;
            }
            System.out.print(numbersWithLoop[i] + ", ");
        }

        System.out.println();

        System.out.print("while-schleife: ");
        int lengthOfArray =  numbersWithLoop.length - 1;
        while (lengthOfArray >= 0)  {
            if (lengthOfArray == 0) {
                System.out.print(numbersWithLoop[lengthOfArray--]);
                break;
            }
            System.out.print(numbersWithLoop[lengthOfArray--] + ", ");
        }
    }

    static int[] fillArray(int[] numbersWithLoop) {
        for (int i = 0; i < numbersWithLoop.length; i++) {
            numbersWithLoop[i] = i + 1;
        }
        return numbersWithLoop;
    }

    static int getCountOfSevens(int[] theSecondComingOfIntegerArray){
        int arrayLength = theSecondComingOfIntegerArray.length;
        for (int j : theSecondComingOfIntegerArray) {
            if (j == 7) arrayLength++;
        }
        return arrayLength;
    }
    static int[] minusOnes(int[] theSecondComingOfIntegerArray) {
        int[] arrayOfMinusOnes = new int[getCountOfSevens(theSecondComingOfIntegerArray)];
        int index = 0;
        for (int i = 0; i < arrayOfMinusOnes.length; i++) {
            if (theSecondComingOfIntegerArray[index] != 7) {
                arrayOfMinusOnes[i] = theSecondComingOfIntegerArray[index];
                index++;
            }
            else {
                arrayOfMinusOnes[i] = theSecondComingOfIntegerArray[index];
                index++;
                i++;
                arrayOfMinusOnes[i] = -1;
            }
        }
        return arrayOfMinusOnes;  //we don't talk about this
    }

    static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    static void modNineAndSix(int[] modSixArray) {
        for (int i = 0; i < modSixArray.length; i++) {
            if (modSixArray[i] % 9 == 0) {
                modSixArray[i] = 0;
            }
        }
    }

    static void hashBetween(int[] integerArray) {
        for (int i = 0; i < integerArray.length; i++) {
            if (i + 1 == integerArray.length) {
                System.out.println(integerArray[i]);
                return;
            }
            System.out.print(integerArray[i] + "#");
        }
    }
}

