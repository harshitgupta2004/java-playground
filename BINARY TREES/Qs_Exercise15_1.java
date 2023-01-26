// Check if a Binary Tree is univalued or not
// We have a binary tree, the task is to check if the binary tree is univalued or not.

// TC = O(h)
// SC = O(1)

public class Qs_Exercise15_1 {
    static class Node{
        int data;
        Node left;
        Node right;
    }
    
    static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return (temp);
    }

    public static boolean isUnival(Node root) {
        if(root == null) {
            return true;
        }

        if(root.left != null && root.data != root.left.data) {
            return false;
        }

        if(root.right != null && root.data != root.right.data) {
            return false;
        }

        return isUnival(root.left) && isUnival(root.right);
    }

    public static void main(String args[]) {
        Node root = newNode(1);
        root.left = newNode(1);
        root.right = newNode(1);
        root.left.left = newNode(1);
        root.left.right = newNode(1);
        root.right.right = newNode(1);

        if(isUnival(root)) {
            System.out.println("Yes");
        } else {
            System.err.println("No");
        }
    }
}
