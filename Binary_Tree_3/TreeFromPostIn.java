import java.util.*;

public class TreeFromPostIn {
    public static Node buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
    }

    public static Node build(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
            HashMap<Integer, Integer> hm) {
        if (is > ie || ps > pe) {
            return null;
        }
        Node root = new Node(postorder[pe]);
        int inRoot = hm.get(postorder[pe]);
        int numsLeft = inRoot - is;
        root.left = build(inorder, is, inRoot - 1, postorder, ps, ps + numsLeft - 1, hm);
        root.right = build(inorder, inRoot + 1, ie, postorder, ps + numsLeft, pe - 1, hm);

        return root;
    }
}

// Time complexity: O(N)
// Space complexity: O(N)