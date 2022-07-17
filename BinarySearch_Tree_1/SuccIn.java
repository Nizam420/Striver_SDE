public class SuccIn {
    public static Node inSucc(Node root, Node p){
        Node in = new Node(-1);
        if (root == null){
            return null;
        }
        while (root != null){
            if (p.data >= root.data){
                root = root.right;
            }
            else{
                in = root;
                root = root.left;
            }
        }
        return in;
    }
}

// Time complexity: O(H)
// Space complexity: O(1)