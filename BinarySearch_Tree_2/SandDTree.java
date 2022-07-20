import java.util.*;

class SansDTree {
    public static void main(String[] args) {

    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(Node root) {
            if (root == null) {
                return "";
            }
            Queue<Node> q = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            q.add(root);
            while (!q.isEmpty()) {
                Node node = q.poll();
                if (node == null) {
                    sb.append("n ");
                    continue;
                }
                sb.append(node.data + " ");
                q.add(node.left);
                q.add(node.right);
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            if (data == "") {
                return null;
            }
            Queue<Node> q = new LinkedList<>();
            String[] values = data.split(" ");
            Node root = new Node(Integer.parseInt(values[0]));
            q.add(root);
            for (int i = 1; i < values.length; i++) {
                Node parent = q.poll();
                if (!values[i].equals("n")) {
                    Node left = new Node(Integer.parseInt(values[i]));
                    parent.left = left;
                    q.add(left);
                }
                if (!values[++i].equals("n")) {
                    Node right = new Node(Integer.parseInt(values[i]));
                    parent.right = right;
                    q.add(right);
                }
            }
            return root;
        }
    }

}
// Time complexity: O(N)
// Space complexity: O(1)