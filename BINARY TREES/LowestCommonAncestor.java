import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class LowestCommonAncestor {
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

    // APPROACH - 1: TC = SC = O(n)

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if(root == null) {
            return false;
        }
        
        path.add(root);
        if(root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if(foundLeft || foundRight) {
            return true;
        }

        // not found in both left and right, then, my current root is not in the path, so remove current root which is at last index
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last common ancestor
        int i = 0;
        for(; i < path1.size() && i < path2.size(); i++) {
            if(path1.get(i) != path2.get(i)) {
                break;
            }
        } 

        // last equal node -> i-th index, because above when loop breaks, it points to unequal value
        Node lca = path1.get(i-1);
        return lca;
    }   
    
    // APPROACH 2 : TC = O(n) , SC = O(1)

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

    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 5;
        System.out.println(lca(root, n1, n2).data);
        System.out.println(lca2(root, n1, n2).data);
    }
}
