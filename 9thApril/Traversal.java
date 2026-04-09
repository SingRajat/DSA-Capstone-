class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Traversal {

    Node root;

    // Preorder Traversal (Root -> Left -> Right)
    void preorder(Node node) {
        if (node == null) return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // Inorder Traversal (Left -> Root -> Right)
    void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Postorder Traversal (Left -> Right -> Root)
    void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // Invert Binary Tree (Mirror)
    Node invertTree(Node node) {
        if (node == null) return null;

        // swap left and right
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // recursively invert subtrees
        invertTree(node.left);
        invertTree(node.right);

        return node;
    }

    public static void main(String[] args) {
        Traversal tree = new Traversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Preorder:");
        tree.preorder(tree.root);

        System.out.println("\nInorder:");
        tree.inorder(tree.root);

        System.out.println("\nPostorder:");
        tree.postorder(tree.root);

        // Invert tree
        tree.invertTree(tree.root);

        System.out.println("\n\nAfter Inverting:");

        System.out.println("Preorder:");
        tree.preorder(tree.root);

        System.out.println("\nInorder:");
        tree.inorder(tree.root);

        System.out.println("\nPostorder:");
        tree.postorder(tree.root);
        System.out.println();
    }
}
