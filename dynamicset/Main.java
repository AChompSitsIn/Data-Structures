package dynamicset;

public class Main {
    public static void main(String[] args) {
        
        int errorCount = 0;
        DynamicSet set = new DynamicSet();

        // test insert
        set.insert(10);
        set.insert(20);
        set.insert(15);
        set.insert(5);
        set.insert(30);

        // test search 
        if (set.search(15) == -1) {
            System.out.println("error: search failed for 15");
            errorCount++;
        }
        if (set.search(100) != -1) {
            System.out.println("error: search should have failed for 100");
            errorCount++;
        }

        // test minimum
        if (set.minimum() != set.search(5)) {
            System.out.println("error: minimum failed");
            errorCount++;
        }

        // test maximum
        if (set.maximum() != set.search(30)) {
            System.out.println("error: maximum failed");
            errorCount++;
        }

        // test successor
        if (set.successor(15) != set.search(20)) {
            System.out.println("error: successor failed for 15");
            errorCount++;
        }
        if (set.successor(30) != -1) {
            System.out.println("error: successor should have failed for 30");
            errorCount++;
        }

        // test predecessor
        if (set.predecessor(15) != set.search(10)) {
            System.out.println("error: predecessor failed for 15");
            errorCount++;
        }
        if (set.predecessor(5) != -1) {
            System.out.println("error: predecessor should have failed for 5");
            errorCount++;
        }

        // test delete
        set.delete(15);
        if (set.search(15) != -1) {
            System.out.println("error: Delete failed for 15");
            errorCount++;
        }

        System.out.println("Total errors: " + errorCount);
    }
}
