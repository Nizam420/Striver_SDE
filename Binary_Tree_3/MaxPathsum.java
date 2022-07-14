class Solution {
    public int maxPathSum(Node root) {
        int[] maxVal = new int[1];
        maxVal[0] = Integer.MIN_VALUE;
        pathSum(root, maxVal);
        return maxVal[0];
    }
    public int pathSum(Node root, int[] maxVal){
        if (root == null){
            return 0;
        }
        int left = Math.max(0, pathSum(root.left, maxVal));
        int right = Math.max(0, pathSum(root.right, maxVal));
        
        maxVal[0] = Math.max(maxVal[0], left + right + root.data);
        
        return Math.max(left, right) + root.data;
    }
}

// Time complexity: O(N)
// Space complexity: O(N)