package binarysearchtree;

// credit to https://www.geeksforgeeks.org/binary-search-tree-data-structure/ for teaching me about binary search trees and deletion methods

import java.util.ArrayList;

public class BinarySearchTree {
    Node root;

    // initialze the tree with a null root
    BinarySearchTree() {
        this.root = null;
    }

    /**
     * insert a new node into the tree (with duplicate check)
     * @param data the data to be inserted into the tree
     */
    public void insert(int data) {
        if (!search(data)) {
            root = insertR(root, data);
        } 

        /* keep for debugging purposes
        if (search(data)) {
            System.out.println("attempted to insert duplicate value, operation stopped");
        }
        */
    }

    /**
     * recursive method to insert a new node into the tree
     * @param root the current root node
     * @param data the data to be inserted
     * @return the new root node after insertion
     */
    public Node insertR(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertR(root.left, data); // insert intothe  left subtree
        } else if (data > root.data) {
            root.right = insertR(root.right, data); // insert into the right subtree
        }

        return root;
    }

    /**
     * searches for a node with the value 'data' (int)
     * @param data the data (int) to search for
     * @return true if the data is found and false otherwise
     */
    public boolean search(int data) {
        return searchR(root, data);
    }

    /**
     * recursive method to search for a node in the tree
     * @param root the current root node
     * @param data the data to searh for
     * @return true if the data is found false otherwise
     */
    public boolean searchR(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }

        if (data < root.data) {
            return searchR(root.left, data); // search left
        }

        if (data > root.data) {
            return searchR(root.right, data); // search ritgh
        }

        return false;
    }

    /**
     * deletess a node with specified data
     * @param data the data to be deleted from the tree
     */
    public void delete(int data) {
        if (search(data)) {
            ArrayList<Integer> toReinsert = new ArrayList<>(); // stoReinserte values to reinsert
            collectRST(root, data, toReinsert); // collect values from the right subtree
            root = deleteR(root, data);
            for (int value : toReinsert) {
                insert(value);
            }
        }
    }

    /**
     * recursive mehtod to delete a node with specified data
     * @param root the current root node
     * @param data the data to be deleted
     * @return the new root node after deletion
     */
    public Node deleteR(Node root, int data) {
        if (root == null) {
            return root; // return if root is null
        }
        if (data < root.data) {
            root.left = deleteR(root.left, data); // delete from left subtree
        } else if (data > root.data) {
            root.right = deleteR(root.right, data); // delete from right subtree
        } else {
            // node to be deleted found
            if (root.left == null) {
                return root.right; // return right child if left is null
            } else if (root.right == null) {
                return root.left; // return left child if right is null
            }

            root.data = minV(root.right); // find the minimum value in the right subtree
            root.right = deleteR(root.right, root.data); // delete the inorder successor
        }

        return root; // return the new root
    }

    /**
     * finds the min val in a subtree
     * @param root the root of the subtree
     * @return the minimum value in the subtree
     */
    public int minV(Node root) {
        int minV = root.data;

        while (root.left != null) {
            root = root.left;
            minV = root.data;
        }
        return minV;
    }

    /**
     * collects all vals from right subtree of the specified node
     * @param root the currrent root node
     * @param data the data whose right subtree values are to be collected
     * @param toReinsert list to stoReinserte the collected values
     */
    public void collectRST(Node root, int data, ArrayList<Integer> toReinsert) {
        if (root == null) {
            return;
        }
        if (data < root.data) {
            collectRST(root.left, data, toReinsert); // left tree
        } else if (data > root.data) {
            collectRST(root.right, data, toReinsert); // rightt tree
        } else {
            cAV(root.right, toReinsert);
        }
    }

    /**
     * collect all values from a subtree and puts them into a big unsorted list (very inefficent and slow sorry)
     * @param root the root of the subtree
     * @param values list to stoReinserte the collected values
     */
    public void cAV(Node root, ArrayList<Integer> values) {
        if (root != null) {
            cAV(root.left, values); // colleft left subtftree
            values.add(root.data); // stoReinsertes the root
            cAV(root.right, values); // collect from left subtree
        }
    }
}
