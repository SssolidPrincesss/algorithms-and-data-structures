import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

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

public class BSTLeaves {

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

	public static int height(Node root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean isAVLBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int balanceFactor = Math.abs(height(root.left) - height(root.right));

        if (balanceFactor > 1) {
            return false;
        }

        return isAVLBalanced(root.left) && isAVLBalanced(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;
        int data;
        while ((data = scanner.nextInt()) != 0) {
            root = insert(root, data);
        }
        scanner.close();

        if (isAVLBalanced(root)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}

