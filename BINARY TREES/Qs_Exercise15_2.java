// Invert Binary Tree
// Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.

// TC = O(n)
// SC = O(n)

import java.util.*;
public class Qs_Exercise15_2 {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    void mirror() {
        root = mirror(root);
    }

    Node mirror(Node node) {
        if(node == null) {
            return node;
        }

        // do the subtrees
        Node left = mirror(node.left);
        Node right = mirror(node.right);

        // swap the left and right pointers
        node.left = right;
        node.right = left;

        return node;
    }

    void inOrder() {
        inOrder(root);
    }

    void inOrder(Node node) {
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.data+" ");

        inOrder(node.right);
    }

    public static void main(String args[]) {
        Qs_Exercise15_2 tree = new Qs_Exercise15_2();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder();
        
        System.out.println("");
        
        tree.mirror();
        System.out.println("Inorder traversal of binary tree is : ");
        tree.inOrder();
    }
}


