import java.util.*;
class Solution {
    public Node buildTree(int[] preorder, int[] inorder) {
        Map < Integer, Integer > inMap = new HashMap < Integer, Integer > ();

        for (int i = 0; i < inorder.length; i++) {
          inMap.put(inorder[i], i);
        }

        Node root = build(preorder, 0, preorder.length - 1, inorder, 0, 
        inorder.length - 1, inMap);
        return root;
    }
    public static Node build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }
        Node root = new Node(preorder[preStart]);
        int inRoot = inMap.get(root.data);
        int numsLeft = inRoot - inStart;
        
        root.left = build(preorder, preStart + 1, preStart + numsLeft, inorder, 
        inStart, inRoot - 1, inMap);
        root.right = build(preorder, preStart + numsLeft + 1, preEnd, inorder, 
        inRoot + 1, inEnd, inMap);

        return root;
    }
}

// Time complexity: O(N)
// Space complexity: O(N)