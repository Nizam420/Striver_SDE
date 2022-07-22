import java.util.*;
 class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
      ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
      int ideg[]=new int[n+1];
        for(int i=0;i<=n;i++){
            ArrayList<Integer> ar=new ArrayList<Integer>();
            adj.add(ar);
        }
        for(int i=0;i<edges.size();i++){
            ArrayList<Integer> temp=edges.get(i);
            int a=temp.get(0);
            int b=temp.get(1);
            ArrayList<Integer> temp2=adj.get(a);
            temp2.add(b);
            ideg[b]++;
        }
      int c=0;
      Queue<Integer> q=new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            if(ideg[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.poll();
            c++;
            for(Integer it: adj.get(node)){
                ideg[it]--;
                if(ideg[it]==0)
                    q.add(it);
            }
        }
        return c==n?false:true;
    }
}

// Time complexity: O(N+E), Where N is the time taken for visiting N nodes and E is for travelling through adjacent nodes.

// Space Complexity:O(N+E)+O(N)+O(N) , Space for adjacency list, Array,Auxiliary space.