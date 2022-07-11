import java.util.*;
class Pair{
    Node node;
    int hd;
    Pair(Node node, int data){
        this.node = node;
        this.hd = data;
    }
}
public class TopView {
    public static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()){
            Pair it  = q.remove();
            int hd = it.hd;
            Node temp = it.node;
            if (map.get(hd) == null){
                map.put(hd, temp.data);
            }
            if (temp.left != null){
                q.add(new Pair(temp.left, hd - 1));
            }
            if (temp.right != null){
                q.add(new Pair(temp.right, hd+1));
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}

// Time Complexity: O(N)

// Space Complexity: O(N)