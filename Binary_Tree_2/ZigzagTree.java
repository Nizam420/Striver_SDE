
import java.util.*;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if (root == null){
            return ans;
        }
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < size; i++){
                if (q.peek().left != null){
                    q.offer(q.peek().left);
                }
                if (q.peek().right != null){
                    q.offer(q.peek().right);
                }
                if (flag == true){
                    sub.add(q.poll().data);
                }
                else{
                    sub.add(0, q.poll().data);
                }
            }
            flag = !flag;
            ans.add(sub);
        }
        return ans;
    }
}

// Time complexity: O(N)
// Space complexity: O(N)