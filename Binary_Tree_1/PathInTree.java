import java.util.*;

public class PathInTree {
    public static boolean getPath(Node root, int x, ArrayList<Integer> ans) {
        if (root == null) {
            return false;
        }
        ans.add(root.data);
        if (root.data == x) {
            return true;
        }
        if (getPath(root.left, x, ans) || getPath(root.right, x, ans)) {
            return true;
        }
        ans.remove(ans.size() - 1);
        return false;
    }

    public static ArrayList<Integer> pathInATree(Node root, int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        getPath(root, x, ans);
        return ans;
    }
}
// Time complexity: O(N)
// Space complexity: O(h)