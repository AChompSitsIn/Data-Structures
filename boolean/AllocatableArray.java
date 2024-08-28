public class AllocatableArray {
    private int[] ar;

    public AllocatableArray(int size) {
        ar = new int[size];
    }

    // changes the size of the array to accommodate other indexes
    public void change_size(int size) {
        int[] temp = ar.clone();

        // if the size is the same, do nothing
        if (size == ar.length) {
            System.out.println("Same size");
            return;
        }

        ar = new int[size];

        // copy old values if the array is shrinking or growing
        int copyLength = Math.min(temp.length, size);
        for (int i = 0; i < copyLength; i++) {
            ar[i] = temp[i];
        }
    }

    // gets the value at a specific index even if the index would normally be out of bounds
    public int get(int index) {
        if (index >= ar.length) {
            change_size(index + 1);
        }
        return ar[index];
    }

    // sets the value at a specific index even if the index would normally be out of bounds
    public void set(int index, int value) {
        if (index >= ar.length) {
            change_size(index + 1);
        }
        ar[index] = value;
        //System.out.println(value + " - " + ar[index]);
    }

    // prints array for debugging
    public void printArray() {
        for (int i : ar) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
