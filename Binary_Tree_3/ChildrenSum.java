public class ChildrenSum {
    public static void changeTree(Node root) {
        if (root == null) {
            return;
        }
        int child = 0;
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }
        if (child >= root.data) {
            child = root.data;
        } else {
            if (root.left != null) {
                root.left.data = root.data;
            } else if (root.right != null) {
                root.right.data = root.data;
            }
        }
        changeTree(root.left);
        changeTree(root.right);

        int tot = 0;
        if (root.left != null) {
            tot += root.left.data;
        }
        if (root.right != null) {
            tot += root.right.data;
        }
        if (root.left != null || root.right != null) {
            root.data = tot;
        }
    }
}

// Time complexity: O(N)
// Space complexity: O(H)