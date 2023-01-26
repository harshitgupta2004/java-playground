import java.util.ArrayList;

import javax.management.relation.Role;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class BinarySearchTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
        }
    }

    // It will insert node in our BST and return our root node value
    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        // correct position find
        if(root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        } else {
            // right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    // O(H) -> height of tree
    public static boolean search(Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if(root.data > key) {
            return search(root.left, key);
        }
        
        else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        } else if(root.data > val) {
            root.left = delete(root.left, val);
        }

        else {
            // case 1 - leaf node
            if(root.left == null && root.right == null) {
                return null;
            }

            // case 2 - single child
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            }

            // case 3 - both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data; // value replace
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if(root == null){
            return;
        }
        
        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1) {
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }

    // ROOT TO LEAF PATHS

    public static void printPath(ArrayList<Integer> path) {
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) + " -> ");
        }
        System.out.println("Null");
    }

    public static void printRoottoLeaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
        
        // all node to path
        path.add(root.data);

        // Base case
        if(root.left == null && root.right == null) {
            printPath(path);
        }

        printRoottoLeaf(root.left, path);
        printRoottoLeaf(root.right, path);

        path.remove(path.size()-1); // data of root node exists on last index
    }

    public static void main(String args[]) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        // traverse array values and insert them one by one in our BST
        for(int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inOrder(root);
        System.out.println();

        if(search(root, 1)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

        root = delete(root, 5);
        System.out.println();

        inOrder(root);
        System.out.println();

        printInRange(root, 5, 12);
        System.out.println();

        printRoottoLeaf(root, new ArrayList<>());
    }
}