package binarysearchtree;

public class BinarySearchTree {
    Node root;

    BinarySearchTree(){
        this.root = null;
    }

    public void insert(int data) {
        root = insertR(root, data);
    }

    public Node insertR(Node root, int data) {

        if(root == null) {
            root = new Node(data);
        }

        // need to recur down tree
        if (data < root.data) {
            root.left = insertR(root.left, data);
        } else if (data > root.data) {
            root.right = insertR(root.right, data);
        }
        return root;
    }

    
}