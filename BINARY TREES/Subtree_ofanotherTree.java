public class Subtree_ofanotherTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int count(Node root) {
        if(root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);

        return leftCount+rightCount+1;
    }

    public static boolean isIdentical(Node node, Node subRoot) { // two trees are identical or not -> 2nd step // here Node node is that node where our subRoot matches with
        
        if(node == null && subRoot == null) {
            return true;
        } 
        // non-identical conditions:
        else if(node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if(! isIdentical(node.left, subRoot.left)) { // left subtree gives non identical
            return false;
        }

        if(! isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot) { // 1st step
        if(root == null){
            return false;
        }
        
        // find node that matches with subRoot
        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));
    }
}