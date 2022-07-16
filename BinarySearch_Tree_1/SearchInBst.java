class Solution {
    public Node searchBST(Node root, int val) {
        while (root != null && root.data != val){
            if (val < root.data){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return root;
    }
}

// Time complexity: O(logN)
// Space complexity: O(1)