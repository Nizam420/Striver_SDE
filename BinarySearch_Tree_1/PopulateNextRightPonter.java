public class PopulateNextRightPonter {
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur.left != null) {
            Node temp = cur;
            while (cur != null) {
                cur.left.next = cur.right;
                cur.right.next = cur.next == null ? null : cur.next.left;
                cur = cur.next;
            }
            cur = temp.left;
        }
        return root;
    }
}
// Time complexity: O(N)
// Space complexity: O(1)
