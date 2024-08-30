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

    public boolean search(int data) {
        return searchR(root, data);
    }

    public boolean searchR(Node root, int data) {

        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }

        if (data < root.data) {
            return searchR(root.left, data);
        } 

        if (data > root.data) {
            return searchR(root.right, data);
        }

        return false;
    }


}