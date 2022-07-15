public class Node {
    int data;
    Node left;
    Node right;
    public int hd;
    public Node next;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.left = new Node(9);
        root.right.right = new Node(14);

    }
}
