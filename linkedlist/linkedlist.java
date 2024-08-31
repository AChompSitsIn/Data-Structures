// (1) https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html nested classes

package linkedlist;

public class linkedlist {

    private static class Node { // see link (1) for nested class credit

        int data;
        Node next;

        Node(int data2) {
            data = data2;
            next = null;
        }
    }

    Node head;

    // initialize head as null
    public linkedlist() {
        head = null;
    }

    public void insert(int data) {
        
        Node n = new Node(data);

        if (head == null) {
            head = n;
        } else {
            Node c = head;
            while (c.next != null) {
                c = c.next;
            }
        c.next = n;
        }
    }
    
}
