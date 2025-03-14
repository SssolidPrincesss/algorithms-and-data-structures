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

    public static void collectOneChildrenNodes(Node root, List<Integer> twoChildrenNodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right != null || root.left != null && root.right == null) {
            twoChildrenNodes.add(root.data);
        }

        collectOneChildrenNodes(root.left, twoChildrenNodes);
        collectOneChildrenNodes(root.right, twoChildrenNodes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;
        int data;
        while ((data = scanner.nextInt()) != 0) {
            root = insert(root, data);
        }
        scanner.close();

        List<Integer> leaves = new ArrayList<>();
        collectOneChildrenNodes(root, leaves);

        Collections.sort(leaves);

        for (int leaf : leaves) {
            System.out.println(leaf);
        }

    }
}

