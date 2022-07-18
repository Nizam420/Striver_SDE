public class KthLargestinBst {
    static int ans = 0;
    static int cnt = 0;

    public static int kthLargest(Node root, int k) {
        inOrder(root, k);
        return ans;
    }

    public static void inOrder(Node root, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.right, k);
        cnt++;
        if (cnt == k) {
            ans = root.data;
            return;
        }
        inOrder(root.left, k);
    }
}
// Time complexity: O(N)
// Space complexity: O(N)