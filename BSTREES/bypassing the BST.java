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

    public static void inorderTraversal(Node root, List<Integer> result) {
        if (root != null) {
            inorderTraversal(root.left, result);
            result.add(root.data);
            inorderTraversal(root.right, result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;
        int data;

        while ((data = scanner.nextInt()) != 0) {
            root = insert(root, data);
        }

        scanner.close();

        List<Integer> sortedData = new ArrayList<>();
        inorderTraversal(root, sortedData);

        for (int i = 0; i < sortedData.size(); i++) {
            System.out.print(sortedData.get(i) + (i == sortedData.size() - 1 ? "" : " "));
        }
		System.out.println();
    }
}
