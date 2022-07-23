import java.util.*;
class Solution {
    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        //Making the adjacency list from edges list
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<edges.size();i++){
            ArrayList<Integer> ar=new ArrayList<Integer>();
            adj.add(ar);
        }
        for(int i=0;i<edges.size();i++){
            for(int j=0;j<edges.get(i).size();j++){
                if(edges.get(i).get(j)==1){
                    ArrayList<Integer> temp1=adj.get(i);
                    ArrayList<Integer> temp2=adj.get(j);
                    temp1.add(j);
                    temp2.add(i);
                }
            }
        }
        //Algorithm
        int vertex=edges.size();
        int vis[]=new int[vertex];
        for(int i=0;i<vertex;i++){
            if(vis[i]==0){
                vis[i]=1;
                if(dfs(vis,i,adj)==false)
                    return false;
            }
        }
        return true;
    }
    static boolean dfs(int []vis,int i,ArrayList<ArrayList<Integer>> adj){
        for(Integer it: adj.get(i)){
            if(vis[it]==0){
                vis[it]=vis[i]==2?1:2;
                if(!dfs(vis,it,adj))
                    return false;
            }
            else if(vis[it]==vis[i])
                    return false;
        }
        return true;
    }
}

// Time Complexity: O(N+E) 

// N = Number of node , E = Number of Edges

// Space Complexity: O(N) + O(N)

// Visited Array and Stack data structure. Both will be using O(N).

// Auxiliary Space Complexity:  O(N)