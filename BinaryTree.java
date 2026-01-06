import java.util.*;

public class BinaryTree {
    Node2 root;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node2(1);
        tree.root.left = new Node2(2);
        tree.root.right = new Node2(3);
        tree.root.left.left = new Node2(4);
        tree.root.left.right = new Node2(5);

        System.out.print("Inorder: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Pre Order: ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Post Order: ");
        tree.postorder(tree.root);
        System.out.println();

        System.out.print("Level Order: ");
        tree.levelOrder(tree.root);
    }

    void inorder(Node2 node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder((node.right));
    }
    void preorder(Node2 node) {
        if(node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
    void postorder(Node2 node) {
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    void levelOrder(Node2 root) {
        if(root == null) return;
        Queue<Node2> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node2 curr = q.poll();
            System.out.print(curr.data + " ");

            if(root.left != null) {
                q.add(curr.left);
            }
            if(curr.right != null) {
                q.add(curr.right);
            }
        }
    }
}

class Node2 {
    int data;
    Node2 left, right;
    Node2(int data) {
        this.data = data;
        left = right = null;
    }
};
