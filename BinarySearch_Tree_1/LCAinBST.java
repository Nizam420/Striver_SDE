public class LCAinBST {
    public static Node LCAinaBST(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }
        int curr = root.data;
        if (curr < p.data && curr < q.data) {
            return LCAinaBST(root.right, p, q);
        }
        if (curr > p.data && curr > q.data) {
            return LCAinaBST(root.left, p, q);
        }
        return root;
    }
}

// Time complexity: O(H)
// Space complexity: O(1)