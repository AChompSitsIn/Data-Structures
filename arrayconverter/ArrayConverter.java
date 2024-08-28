package arrayconverter;
// credit to https://www.w3schools.com/java/java_try_catch.asp - teaching me try catch blocks

/*
 * Will not work if the lenghth of the 1D array is not a perfect square, or if the 2D array is not a square matrix
 * 
 * Will work when the length of the input 1D is a perfect square ex. 4, 9, 16, 25, 36, etc. Results in a square matrix (4x4, 3x3, etc)
 * Will work work the input 2D array is a square matrix
 */

public class ArrayConverter {

    /*
     * 1D array to 2D array
     * @param array1D The input 1D array.
     * @return A 2D array with square dimensions, created from the input 1D array.
     * @throws IllegalArgumentException If the length of the input 1D array is not a perfect square.
     */
public static int[][] to2DArray(int[] array1D) {

    // checks that 1D array length is a perfect square
    int sqrtLength = (int) Math.sqrt(array1D.length);
    if (sqrtLength * sqrtLength != array1D.length) {
        throw new IllegalArgumentException("1D array has invalid dimensions: length is not a perfect square");
    }

    int rows = sqrtLength;
    int cols = sqrtLength;

    // creates and populates the 2D array
    int[][] array2D = new int[rows][cols];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            int index = i * cols + j;
            array2D[i][j] = array1D[index];
        }
    }

    return array2D;
}

    /*
     * converts 2D array to 1D array
     * @param array2D The input 2D array.
     * @return A 1D array created from the input 2D array.
     * @throws IllegalArgumentException If the input 2D array is not a square matrix.
     */
    public static int[] to1DArray(int[][] array2D) {

        // throws error if input is not a square
        if (!checkSquare(array2D)) {
            throw new IllegalArgumentException("2D array has invalid dimensions: not a square");
        }

        int rows = array2D.length;
        int cols = array2D[0].length;
        
        int[] array1D = new int[rows * cols];

        // iterates through each row and column to make it into 1D array
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                array1D[index] = array2D[i][j];
            }
        }
        
        return array1D;
    }

    /*
     * print 2d arrays
     * @param source The 2D array to be printed.
     */
    public static void p2d(int[][] source) {
        System.out.println("2D Array:");
        for (int[] row : source) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    /*
     * print 1d arrays
     * @param source The 1D array to be printed.
     */
    public static void p1d(int[] source) {
        System.out.println("\n1D Array:");
        for (int element : source) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int passedTests = 0;
        int failedTests = 0;
    
        // test 1: 1D to 2D (valid perfct square)
        int[] array1D_1 = {1, 2, 3, 4};
        int[][] expected2D_1 = {
            {1, 2},
            {3, 4}
        };
        int[][] actual2D_1 = null;
        try {
            actual2D_1 = to2DArray(array1D_1);
            if (arraysEqual(actual2D_1, expected2D_1) && checkSquare(actual2D_1)) {
                passedTests++;
                System.out.println("test case 1 (1D to 2D) passed");
            } else {
                failedTests++;
                System.out.println("test case 1 (1D to 2D) failed");
            }
        } catch (IllegalArgumentException e) {
            failedTests++;
            System.out.println("test case 1 (1D to 2D) failed - Exception: " + e.getMessage());
        }
    
        // test case 2: 1D to 2D (invalid lengthis not perfect square)
        int[] array1D_2 = {1, 2, 3, 4, 5};
        try {
            to2DArray(array1D_2);
            failedTests++;
            System.out.println("test case 2 (1D to 2D) failed - no exception was thrown for a nonsquare length");
        } catch (IllegalArgumentException e) {
            passedTests++;
            System.out.println("test case 2 (1D to 2D) passed - properly handled a nonsquare length");
        }
    
        // test case 3: 2D to 1D (valid matrix is square)
        int[][] array2D_3 = {
            {1, 2},
            {3, 4}
        };
        int[] expected1D_3 = {1, 2, 3, 4};
        try {
            int[] actual1D_3 = to1DArray(array2D_3);
            if (arraysEqual(new int[][]{actual1D_3}, new int[][]{expected1D_3}) && checkSquare(array2D_3)) {
                passedTests++;
                System.out.println("test case 3 (2D to 1D) passed");
            } else {
                failedTests++;
                System.out.println("test case 3 (2D to 1D) failed");
            }
        } catch (IllegalArgumentException e) {
            failedTests++;
            System.out.println("test case 3 (2D to 1D) failed - error: " + e.getMessage());
        }
    
        // test case 4: 2D to 1D (invalid matrix is not square)
        int[][] array2D_4 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        try {
            to1DArray(array2D_4);
            failedTests++;
            System.out.println("test case 4 (2D to 1D) failed - no exception was thrown for a nonsquare matrix");
        } catch (IllegalArgumentException e) {
            passedTests++;
            System.out.println("test case 4 (2D to 1D) passed - correctly handled nonsqaure matrix");
        }
    
        // result summary
        System.out.println("----------------------------------------------");
        System.out.println("Ignore above messages unless Tests failed != 0");
        System.out.println("Summary of Test Results:");
        System.out.println("Tests passed: " + passedTests);
        System.out.println("Tests failed: " + failedTests);
        System.out.println("----------------------------------------------");
    }

    /*
     * compares two 2D arrays
     * @param actual The actual 2D array.
     * @param expected The expected 2D array.
     * @return true if the arrays are equal in structure and content, false otherwise.
     */
    public static boolean arraysEqual(int[][] actual, int[][] expected) {

        // checks the rows of both arrays
        if (actual.length != expected.length) {
            return false;
        }

        // checks if the columns in each row is the same
        for (int i = 0; i < actual.length; i++) {
            if (actual[i].length != expected[i].length) {
                return false;
            }

            // checks if the current position's elements are as expected
            for (int j = 0; j < actual[i].length; j++) {
                if (actual[i][j] != expected[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    /*
     * checks if a 2d array is a square by comparing the number of rows to the number of columns
     * @param check The 2D array to check.
     * @return true if the array is a square matrix, false otherwise.
     */
    public static boolean checkSquare(int[][] check) {

        int sqColLen = check[0].length;
        int row = 0;

        // loops through each array stored within the 2d array and checks length making sure that the rows = the cols
        for (int i = 0; i < check.length; i++) {
            
            if (check[i].length != sqColLen) {
                System.out.println("test failed, row != col");
                return false;
            } else {
                // store to test later
                row++;
            }
    }

    // final check for # of rows = # of cols for printing debug msgs
    if (row == sqColLen) {
        System.out.println("square test passed");
        return true;
    } else {
        System.out.println("test failed... Row: " + row + " Col " + sqColLen);
    }
    return false;
}
}