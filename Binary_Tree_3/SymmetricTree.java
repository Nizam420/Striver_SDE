class Solution {
    public boolean isSymmetric(Node root) {
        if (root == null) {
            return false;
        }
        return check(root.left, root.right);
    }

    public boolean check(Node left, Node right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.data != right.data) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}

// Time complexity: O(N)
// Space complexity: O(N)