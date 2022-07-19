class NodeValue {
    public int maxNode, minNode, sum;

    public NodeValue(int minNode, int maxNode, int sum) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
    }
}

class MaxSumBstinBT {
    public static void main(String[] args) {

    }

    int maxSum = 0;

    public int maxSumBST(Node root) {
        // NodeValue obj = largestBSTSubtreeSum(root);
        largestBSTSubtreeSum(root);
        return maxSum > 0 ? maxSum : 0;

    }

    private NodeValue largestBSTSubtreeSum(Node root) {
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Get values from left & right subtree of current tree
        NodeValue left = largestBSTSubtreeSum(root.left);
        NodeValue right = largestBSTSubtreeSum(root.right);

        // Current node is greater than max in left & smaller than
        // min in right, it is a BST
        if (left.maxNode < root.data && root.data < right.minNode) {
            maxSum = Math.max(maxSum, root.data + left.sum + right.sum);
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
                    root.data + left.sum + right.sum);
        }

        // Otherwise return [-int, int] so that parent can't be
        // valid BST
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.sum, right.sum));
    }
}
// Time complexity: O(N)
// Space complexity: O(1)