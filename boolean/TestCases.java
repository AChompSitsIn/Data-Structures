public class TestCases {

    public static void performTests() {

        AllocatableArray A = new AllocatableArray(1);

        int passedSetTests = 0;
        int failedSetTests = 0;
        int passedGetTests = 0;
        int failedGetTests = 0;

        // test cases for the set method
        A.set(2, 5);
        passedSetTests += checkTestResult(A.get(2), 5);

        A.set(0, 3);
        passedSetTests += checkTestResult(A.get(0), 3);

        A.set(10, 7);
        passedSetTests += checkTestResult(A.get(10), 7);

        A.set(5, 9);
        passedSetTests += checkTestResult(A.get(5), 9);

        // Test cases for the get method
        passedGetTests += checkTestResult(A.get(2), 5); // expected 5
        passedGetTests += checkTestResult(A.get(0), 3); // expected 3
        passedGetTests += checkTestResult(A.get(10), 7); // expected 7
        passedGetTests += checkTestResult(A.get(5), 9); // expected 9

        failedSetTests = 4 - passedSetTests;
        failedGetTests = 4 - passedGetTests;

        // print the number of tests passed and failed for set method
        System.out.println("set tests passed: " + passedSetTests);
        System.out.println("set tests failed: " + failedSetTests);

        // print the number of tests passed and failed for get method
        System.out.println("get tests passed: " + passedGetTests);
        System.out.println("get tests failed: " + failedGetTests);
    }

    // check the test result
    private static int checkTestResult(int actual, int expected) {
        if (actual == expected) {
            return 1; // pass
        } else {
            System.out.println("test failed: expected " + expected + ", got " + actual);
            return 0; // fail
        }
    }
}
