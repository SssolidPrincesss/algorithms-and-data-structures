

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinarySearchTree {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static int height(Node root){
        if(root == null){
            return -1;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;
        int data;

        while ((data = scanner.nextInt()) != 0) {
            root = insert(root, data);
        }

        scanner.close();

        int treeHeight = 1 + height(root);

		System.out.print(treeHeight);
    }
}