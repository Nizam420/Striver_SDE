class Solution {
    public Node sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        return bst(nums, 0, nums.length-1);
    }
    public Node bst(int[] nums, int start, int end){
        if (start > end){
            return null;
        }
        if (start == end){
            return new Node(nums[start]);
        }
        int mid = (start + end)/2;
        Node root = new Node(nums[mid]);
        root.left = bst(nums, start, mid-1);
        root.right = bst(nums, mid+1, end);
        return root;
    }
}

// Time complexity: O(logN)
// Space complexity: O(1)