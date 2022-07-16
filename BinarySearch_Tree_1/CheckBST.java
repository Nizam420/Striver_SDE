class Solution {
    public boolean isValidBST(Node root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(Node root, long minVal, long maxVal){
        if (root == null){
            return true;
        }
        if (root.data >= maxVal || root.data <= minVal){
            return false;
        }
        return isValid(root.left, minVal, root.data) && isValid(root.right, root.data, maxVal);
    }
}
// Time complexity: O(N)
// Space complexity: O(1)