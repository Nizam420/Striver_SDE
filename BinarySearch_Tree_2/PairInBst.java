
import java.util.*;
public class PairInBst {
    static HashSet<Integer> hs = new HashSet<>();

    public static boolean findTarget(Node root, int k) {
        find(root);
        for (int i : hs) {
            if (hs.contains(k - i) && i != k - i) {
                return true;
            }
        }
        return false;
    }

    public static void find(Node root) {
        if (root == null) {
            return;
        }
        find(root.left);
        hs.add(root.data);
        find(root.right);
    }
}

// Time complexity: O(N)
// Space complexity: O(N)