class Solution {
    public Node bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    public Node bst(int[] preorder, int bound, int[] i){
        if (i[0] == preorder.length || preorder[i[0]] > bound){
            return null;
        }
        Node root = new Node(preorder[i[0]++]);
        root.left = bst(preorder, root.data, i);
        root.right = bst(preorder, bound, i);
        return root;
    }
}


// Time complexity: O(N)
// Space complexity: O(1)