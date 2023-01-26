public class MinDist {

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

    public static Node lca2(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // leftLCA = valid value, but rightLCA = null
        // it means n1 & n2 both in left, so their lca will also exists in left
        if(rightLca == null) {
            return leftLca;
        }

        // rightLCA = valid val, leftLCA = null
        if(leftLca == null) {
            return rightLca;
        }

        // if both not null, means in one subtree one n1 exists, in another subtree another n2 exists, means i am their 1st common ancestor
        return root;
    }

    public static int lcaDist(Node root, int n) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        } else if(leftDist == -1) {
            return rightDist+1;
        } else {
            return leftDist+1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dis1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dis1+dist2;

    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 6;
        System.out.println(minDist(root, n1, n2));
    }
}


