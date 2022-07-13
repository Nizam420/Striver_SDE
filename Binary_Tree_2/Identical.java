class Solution {
    public boolean isSameTree(Node p, Node q) {
        if (p == null || q == null){
            return p == q;
        }
        return (p.data == q.data && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}

// Time complexity: O(N)
// Space complexity: O(N)