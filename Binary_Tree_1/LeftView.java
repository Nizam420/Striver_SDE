import java.util.ArrayList;

class Solution 
{
    public static void find(int level, Node root, ArrayList<Integer> ans){
        if (root == null){
            return;
        }
        if (level == ans.size()){
            ans.add(root.data);
        }
        find(level + 1, root.left, ans);
        find(level + 1, root.right, ans);
    }
    public static ArrayList<Integer> getLeftView(Node root) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        find(0, root, ans);
        return ans;
    }
}

// Time complexity: O(N)
// Space complexity: O(h)