import java.util.*;
public class Pre_In_Post {
     public static void main(String[] args) {
        
     }
     public static class Pair {
        Node node;
        int num;

        Pair(Node node, int num) {
            this.node = node;
            this.num = num;
        }
    }
     public static List<List<Integer>> getTreeTraversal(Node root) {
        Stack<Pair> st = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair it = st.pop();
            if (it.num == 1) {
                pre.add(it.node.data);
                it.num++;
                st.push(it);
                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            } else if (it.num == 2) {
                in.add(it.node.data);
                it.num++;
                st.push(it);
                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            } else if (it.num == 3) {
                post.add(it.node.data);
            }
        }
        ans.add(in);
        ans.add(pre);
        ans.add(post);
        return ans;
    }
}
