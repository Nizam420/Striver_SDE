import java.util.*;

 class Solution 
{
    public static void topoSort(ArrayList<ArrayList<Integer>> adj, ArrayList<Boolean> visit, Stack<Integer> stk, int src) 
    {
       
        visit.set(src, true);  
    
        
        for(int node : adj.get(src)) 
        {
            if(!visit.get(node)) 
            {
                topoSort(adj, visit, stk, node);
            }
        }
        
        
        stk.push(src);
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < v; i++) 
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0 ; i<edges.size() ; i++)
        {
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }

        ArrayList<Boolean> visit = new ArrayList<>();
        for(int i = 0; i < v; i++) 
        {
            visit.add(false);
        }

        Stack<Integer> stk = new Stack<>();

      
        for(int i = 0; i < v; i++) 
        {
            if(!visit.get(i)) 
            {
               topoSort(adj, visit, stk, i);
            }
        }

      
        ArrayList<Integer> result = new ArrayList<>();
        while(!stk.empty()) 
        {
            result.add(stk.pop());
        }

        return result;
    }
}

// Time Complexity: O(N+E) 

// N = Number of node , E = Number of Edges

// Space Complexity: O(N) + O(N)

// Visited Array and Stack data structure. Both will be using O(N).

// Auxiliary Space Complexity:  O(N)