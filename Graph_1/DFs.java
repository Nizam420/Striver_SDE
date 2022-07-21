import java.util.*;
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans){
        ans.add(node);
        vis[node] = true;
        for (Integer it : adj.get(node)){
            if (vis[it] == false){
                dfs(it, vis, adj, ans);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V+1];
        
        dfs(0, vis, adj, ans);
        return ans;
    }
}

// Time complexity: O(N+E), Where N is the time taken for visiting N nodes and E is for travelling through adjacent nodes.

// Space Complexity:O(N+E)+O(N)+O(N) , Space for adjacency list, Array,Auxiliary space.