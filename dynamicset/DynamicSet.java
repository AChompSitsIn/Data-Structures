// doubling size instead of adding 1 each time https://stackoverflow.com/questions/20448031/is-doubling-the-capacity-of-a-dynamic-array-necessary
// copyOf https://www.geeksforgeeks.org/arrays-copyof-in-java-with-examples/

package dynamicset;

import java.util.Arrays;

public class DynamicSet {
    private int[] array;
    private int size;

    /**
     * constructor initializes the dynamic set with an initial capacity of 10
     * sets the intial size to 0
     */
    public DynamicSet() {
        this.array = new int[10];
        this.size = 0;
    }

    /**
     * resizes the internal array if the currnt size reaches the capacity
     * increases by doubling it each time becuase thats more effcient 
     */
    private void resize() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    /**
     * serches for an element in the set
     * @param x the element to search for
     * @return the index of the element if found else -1
     */
    public int search(int x) {
        for (int i = 0; i < size; i++) {
            if (array[i] == x) {
                return i;
            }
        }
        return -1;
    }

    /**
     * inserts a new elment into the set
     * resizes the array if necessary before insrtion
     * @param x the elment to insert
     */
    public void insert(int x) {
        resize();
        array[size++] = x;
    }

    /**
     * deletes an element from the set if it exits
     * shifts remaining elements to mintain order
     * @param x the elment to delete
     */
    public void delete(int x) {
        int index = search(x);
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    /**
     * finds the index of the minimum elment in the set
     * @return the index of the minmum element
     */
    public int minimum() {
        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * finds the index of the maxmum element in the set
     * @return the index of the maximum elment
     */
    public int maximum() {
        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * finds the index of the smallest elment greater than the given value
     * @param x the value to find the sucsessor of
     * @return the index of the sucessor or -1 if none exsts
     */
    public int successor(int x) {
        int successorIndex = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] > x && (successorIndex == -1 || array[i] < array[successorIndex])) {
                successorIndex = i;
            }
        }
        return successorIndex;
    }

    /**
     * finds the index of the largets element smaller than the given value
     * @param x the value to find the prdecessor of
     * @return the index of the predecessor or -1 if none exsts
     */
    public int predecessor(int x) {
        int predecessorIndex = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] < x && (predecessorIndex == -1 || array[i] > array[predecessorIndex])) {
                predecessorIndex = i;
            }
        }
        return predecessorIndex;
    }
}