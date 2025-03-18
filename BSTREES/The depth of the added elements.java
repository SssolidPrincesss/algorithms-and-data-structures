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

public class BSTDepth {

    public static Node insert(Node root, int data, int depth) {
        if (root == null) {
            System.out.print(depth + " ");
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data, depth + 1);
        } else if (data > root.data) {
            root.right = insert(root.right, data, depth + 1);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;
        int data;
        while ((data = scanner.nextInt()) != 0) {
                root = insert(root, data, 1);
        }
        scanner.close();
    }
}
