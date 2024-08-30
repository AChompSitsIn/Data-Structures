package binarysearchtree;

public class BinarySearchTree {
    Node root;

    BinarySearchTree(){
        this.root = null;
    }

    public void insert(int data) {
        if (!search(data)) {
            root = insertR(root, data);
        } else {
            //System.out.println("attempted to insert duplicate, insertion stopped");
        }
    }

    public Node insertR(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
    
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

    public void delete(int data) {
        root = deleteR(root, data);
    }

    public Node deleteR(Node root, int data) {

        if (root == null) {
            return root;
        }
        if (data < root.data) {
            root.left = deleteR(root.left, data);
        } else if (data > root.data) {
            root.right = deleteR(root.right, data);
        }

        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minV(root.right);
            root.right = deleteR(root.right, root.data);
        }

        return root;


    }

    public int minV(Node root) {
        
        int minV = root.data;

        while(root.left != null) {
            root = root.left;
            minV = root.data;
        }
        return minV;
    }
}