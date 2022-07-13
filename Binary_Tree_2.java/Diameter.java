class Solution {
    public int diameterOfBinaryTree(Node root) {
        int[] dia = new int[1];
        find(root, dia);
        return dia[0];
    }
    public static int find(Node root, int[] dia){
        if (root == null){
            return 0;
        }
        int lh = find(root.left, dia);
        int rh = find(root.right, dia);
        dia[0] = Math.max(dia[0], lh+rh);
        return 1 + Math.max(lh, rh);
    }
}

// Time complexity: O(N)
// Space complexity: O(h)