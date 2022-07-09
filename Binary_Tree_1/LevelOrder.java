/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Queue<Node> q = new LinkedList<Node>();
        if (root == null){
            return list;
        }
        q.offer(root);
        while (!q.isEmpty()){
            int len = q.size();
            List<Integer> sub = new LinkedList<Integer>();
            for (int i = 0; i < len; i++){
                if (q.peek().left != null){
                    q.offer(q.peek().left);
                }
                if (q.peek().right != null){
                    q.offer(q.peek().right);
                }
                sub.add(q.poll().data);
            }
            list.add(sub);
        }
        return list;
    }
}

// Time complexity: O(N)
// Space complexity: O(N)