import java.util.*;
public class BstIterator {
    private Stack<Node> st = new Stack<>();

    public void BSTIterator(Node root) {
        pushAll(root);
    }
    
    public int next() {
        Node temp = st.pop();
        pushAll(temp.right);
        return temp.data;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void pushAll(Node node){
        for (; node != null; st.push(node), node = node.left);
    }
}

// Time complexity: O(N)
// Space complexity: O(H)
