public class Build_TreePreorder {

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

    static class BinaryTree {
        static int idx = -1; // because we want the index to update at each node
        
        public static Node buildTree(int nodes[]) { // here, we return the root of our tree
            // now, we have to update our index one by one go to the nos at the sequence, and unse no nikal kr data ki help se node create krni hai
            idx++;
            if(nodes[idx] == -1) {
                return null; // because there on no need to create left and right childs of a null node
            }

            Node newNode = new Node(nodes[idx]); // with the help of data which is stored in the idx of node, we will create a new node
            newNode.left = buildTree(nodes); // left subtree
            newNode.right = buildTree(nodes); // right subtree

            return newNode;
        }
    }
    public static void main(String args[]) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
    }
}