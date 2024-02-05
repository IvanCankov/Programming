// A data buffer for a large number of elements (as in the case of large images),
// that are organized into separate arrays (data banks).
public class SimpleDataBufferInt {

    // TODO: make these three variables 'private' and remove 'static'.

    private int numberOfBanks = 6;
    private final int bankSize;
    private final int[][] data;

    // Initializes 'this' with a specified number of banks, all having the same length
    // given by 'bankSize'.
    // Preconditions: numberOfBanks > 0, bankSize > 0
    public SimpleDataBufferInt(int numberOfBanks, int bankSize) {

        this.numberOfBanks = numberOfBanks;
        this.bankSize = bankSize;
        this.data = new int[numberOfBanks][bankSize];

    }

    // Returns the element with index 'i' of the bank array with index 'bankIndex'.
    // Precondition: all indices are valid (needs not be checked).
    public int getElem(int bankIndex, int i) {

        // TODO: modify method to become an object method (not static).
        return this.data[bankIndex][i];
    }

    // Sets the element with index 'i' of the bank array with index 'bankIndex'.
    // Precondition: all indices are valid (needs not be checked).
    public void setElem(int bankIndex, int i, int value) {

        // TODO: modify method to become an object method (not static).
        this.data[bankIndex][i] = value;
    }

    public void setRow(int rowIndex, int[] values) {
        this.data[rowIndex] = values;
    }

    public int[] getRow(int rowIndex) {
        return this.data[rowIndex];
    }

    public int getNumberOfBanks() {
        return this.numberOfBanks;
    }
}
