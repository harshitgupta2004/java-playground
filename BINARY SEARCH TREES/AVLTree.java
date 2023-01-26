public class AVLTree{
    static class Node{
        int data, height; // because we need height for bf
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static Node root;

    public static int height(Node root) {
        if(root == null){
            return 0;
        }
        return root.height;
    }

    static int max(int a, int b){
        return (a > b) ? a : b;
    }

    public static int getBalance(Node root) {
        if(root == null) {
            return 0;
        } 
        return height(root.left) - height(root.right);
    }

    // Right Rotate subtree rooted with y
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // return new root
        return x;
    }

    // Left Rotate subtree rooted with x
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // return new root
        return y;
    }

    public static Node insert(Node root, int key) {
        if(root == null){
            return new Node(key);
        }

        if(key < root.data) {
            root.left = insert(root.left, key);
        } else if(key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // duplicate keys not allowed
        }

        // update root height
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // get root's balance factor
        int bf = getBalance(root);

        // Left Left Case
        if(bf > 1 && key < root.left.data){ // insertion at left side means ht of left side increases, so bf inc by +1
            return rightRotate(root);
        }

        // Right Right Case
        if(bf < -1 && key > root.right.data) { // when rightside ht incr, bf dec by -1
            return leftRotate(root);
        }

        // Left Right Case
        if(bf > 1 && key > root.left.data) { // left ke right child bhi left me hi aata hai thats why >1
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if(bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
                return leftRotate(root);
        }

        return root; // returned if AVL Balanced
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        
        preorder(root);
    }
}