class Solution {
    public boolean isBalanced(Node root) {
        int ans = find(root);
        if (ans == -1) {
            return false;
        }
        return true;
    }

    public static int find(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = find(root.left);
        if (lh == -1) {
            return -1;
        }
        int rh = find(root.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return 1 + Math.max(lh, rh);
    }
}

// Time complexity: O(N)
// Space complexity: O(N)