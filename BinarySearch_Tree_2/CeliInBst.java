public class CeliInBst {
    public static int celiInBST(Node root, int X) {
        int celi = -1;
        while (root != null) {
            if (root.data == X) {
                celi = root.data;
                return celi;
            }
            if (X > root.data) {
                root = root.right;
            } else {
                celi = root.data;
                root = root.left;
            }
        }
        return celi;
    }
}
// Time complexity: O(log N)
// Space complexity: O(1)
