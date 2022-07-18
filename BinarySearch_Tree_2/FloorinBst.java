public class FloorinBst {
    public static int floorInBST(Node root, int X) {
        int flor = -1;
        while (root != null) {
            if (root.data == X) {
                flor = root.data;
                return flor;
            }
            if (X > root.data) {
                flor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return flor;
    }
}

// Time complexity: O(log N)
// Space complexity: O(1)