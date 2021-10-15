package GradedAssignment3DataStructuresA;

import static GradedAssignment3DataStructuresA.Main.BST.*;

class Node {
    int val;
    Node left, right;

    Node(int item) {
        val = item;
        left = right = null;
    }
}
public class Main {

    public static void main(String[] args) {
        BST st = new BST();
        st.node = new Node(50);
        st.node.left = new Node(30);
        st.node.right = new Node(60);
        st.node.left.left = new Node(10);
        st.node.right.left = new Node(40);

        int order = 0;

      flattenBTToSkewed(node, order);
      traverseRightSkewed(headNode);

    }

     static class BST {
        public static Node node;
        static Node prevNode = null;
        static Node headNode = null;

        static void flattenBTToSkewed(Node root, int order) {
            if (root == null) {
                return;
            }
            if (order > 0) {
                flattenBTToSkewed(root.right, order);
            } else {
                flattenBTToSkewed(root.left, order);
            }
            Node rightNode = root.right;
            Node leftNode = root.left;

            if (headNode == null) {
                headNode = root;
                root.left= null;
                prevNode=root;
            } else {
                prevNode.right = root;
                root.left=null;
                prevNode=root;
            }
            if (order > 0) {
                flattenBTToSkewed(leftNode, order);
            } else {
                flattenBTToSkewed(rightNode, order);
            }
        }

        static void traverseRightSkewed(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.val+ " ");
            traverseRightSkewed(root.right);
        }


    }
}

