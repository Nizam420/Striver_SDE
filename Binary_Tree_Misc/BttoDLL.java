class BTtoDLL {
    public static void main(String[] args) {
        
    }
    public void flatten(Node root) {
        Node prev = null;
        Node cur = root;
        while(cur != null){
            if (cur.left != null){
                prev = cur.left;
                while (prev.right != null){
                    prev = prev.right;
                }
                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}

// Time complexity: O(N)
// Space complexity: O(1)