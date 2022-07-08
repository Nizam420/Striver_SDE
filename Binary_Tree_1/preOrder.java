import java.util.*;
public class preOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        List<Integer> preOr = new ArrayList<>();
        pre(root, preOr);

        System.out.println("PreOrder Traversal is :");
        for (int i = 0; i < preOr.size(); i++){
            System.err.print(preOr.get(i) + " ");
        }

    }
    public static void pre(Node root, List<Integer> ans){
        if (root == null){
            return;
        }
        ans.add(root.data);
        pre(root.left, ans);
        pre(root.right, ans);
    }
}
