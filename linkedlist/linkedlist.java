// link (1) https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html

package linkedlist;

/**
 * doubly linked list 
 */
public class linkedlist {

    /**
     * node class for each element; see link (1) for nested class credit
     */
    private static class Node {
        int data;
        Node next;
        Node prev;

        /**
         * initializees new node with specificied data
         * @param data2 the data val for the node to store
         */
        Node(int data2) {
            data = data2;
            next = null;
            prev = null;
        }
    }

    Node head; // start of list

    /**
     * initializes the linked list with head as null
     */
    public linkedlist() {
        head = null;
    }

    /**
     * inserts a new node with the specified data
     * @param data the data to be added to the list
     */
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
            n.prev = c; // link the new node back to the last node (should properly accomodate reverse traversal)
        }
    }

    /**
     * deletes the first node found with data specified
     * @param data the data to be deleted
     */
    public void delete(int data) {
        Node c = head;

        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            if (head != null) {
                head.prev = null; // update the prev pointer
            }
            return;
        }

        while (c != null && c.data != data) {
            c = c.next;
        }

        if (c == null) {
            return;
        }

        if (c.next != null) {
            c.next.prev = c.prev; // link the next nodes prev to the current nodes prev
        }

        if (c.prev != null) {
            c.prev.next = c.next; // link the previous nodes next to the current nodes next
        }
    }

    /**
     * searches for a node with the given data in the list
     * @param data the data to search for
     * @return true if the data is found, false otherwise
     */
    public boolean search(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**
     * prints list
     */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}