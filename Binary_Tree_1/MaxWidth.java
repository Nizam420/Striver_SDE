import java.util.*;

class Pair {
    Node node;
    int num;

    Pair(Node _node, int _num) {
        this.node = _node;
        this.num = _num;
    }
}

public class MaxWidth {
    public static int widthOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().num;
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                int id = q.peek().num - mmin;
                Node node = q.peek().node;
                q.poll();
                if (i == 0) {
                    first = id;
                }
                if (i == size - 1) {
                    last = id;
                }
                if (node.left != null) {
                    q.offer(new Pair(node.left, 2 * id + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, 2 * id + 2));
                }
            }
            ans = Math.max(last - first + 1, ans);
        }
        return ans;
    }
}

// Time complexity: O(N)
// Space complexity: O(N)
