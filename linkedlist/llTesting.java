package linkedlist;

public class llTesting {

    public static void main(String[] args) {
        linkedlist list = new linkedlist();
        int errorCount = 0;

        // insert testing
        list.insert(10);
        list.insert(20);
        list.insert(30);

        // test 1
        if (!list.search(10)) {
            System.out.println("error (1)");
            errorCount++;
        }
        if (!list.search(20)) {
            System.out.println("error (2)");
            errorCount++;
        }
        if (!list.search(30)) {
            System.out.println("error (3)");
            errorCount++;
        }

        // delete testing
        list.delete(20);

        // test 2
        if (list.search(20)) {
            System.out.println("error (4)");
            errorCount++;
        }

        // test 3
        list.delete(40);

        // test 4
        list.delete(10);
        if (list.search(10)) {
            System.out.println("error (5)");
            errorCount++;
        }

        // test 5
        list.delete(30);
        if (list.search(30)) {
            System.out.println("error (6)");
            errorCount++;
        }

        // test search
        list.insert(50);
        list.insert(60);
        list.insert(70);

        // test 6
        if (!list.search(60)) {
            System.out.println("error (7)");
            errorCount++;
        }

        // Test 7
        if (list.search(100)) {
            System.out.println("error (8)");
            errorCount++;
        }

        // test 8
        list.delete(50);
        list.delete(60);
        list.delete(70);
        if (list.search(50) || list.search(60) || list.search(70)) {
            System.out.println("error (9)");
            errorCount++;
        }

        System.out.println("Total errors: " + errorCount);
    }
}