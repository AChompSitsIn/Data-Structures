package binarysearchtree;

public class bstTest {

    public static void main(String[] args) {
        int errorCount = 0;

        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(5);
        bst.insert(20);

        // test 1
        if (bst.root.data != 10) {
            System.out.println("error(1)");
            errorCount++;
        }

        // test 2
        if (bst.root.left.data != 5) {
            System.out.println("error(2)");
            errorCount++;
        }

        // test 3
        if (bst.root.right.data != 20) {
            System.out.println("error(3)");
            errorCount++;
        }

        bst.insert(1);
        bst.insert(25);
        bst.insert(5);

        // test 4
        if (bst.root.left.left.data != 1) {
            System.out.println("error(4)");
            errorCount++;
        }

        // test 5
        if (bst.root.right.right.data != 25) {
            System.out.println("error(5)");
            errorCount++;
        }


        // test 6
        if (bst.root.left.left != null && bst.root.left.left.data != 1) {
            System.out.println("error(6)");
            errorCount++;
        }

        // test 7
        if (!bst.search(10)) {
            System.out.println("error(7)");
            errorCount++;
        }

        // test 8
        if (!bst.search(25)) {
            System.out.println("error(8)");
            errorCount++;
        }

        // test 9
        if (bst.search(100)) {
            System.out.println("error(9)");
            errorCount++;
        }

        bst.delete(1);
        bst.delete(20);
        bst.delete(10);

        // test 10
        if (bst.search(1)) {
            System.out.println("error(10)");
            errorCount++;
        }

        // test 11
        if (bst.search(20)) {
            System.out.println("error(11)");
            errorCount++;
        }

        // test 12
        if (bst.root.data != 25) {
            System.out.println("error(12)");
            errorCount++;
        }

        bst.delete(100);
        bst.delete(5);
        bst.delete(25);

        // test 13
        if (bst.search(5)) {
            System.out.println("error(13)");
            errorCount++;
        }

        // test 14
        if (bst.root != null) {
            System.out.println("error(14)");
            errorCount++;
        }

        System.out.println("total error count: " + errorCount);
    }
}