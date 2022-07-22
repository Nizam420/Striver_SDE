import java.util.*;
// User Defined Object To Pass Node and Parent node in the queue.
class Node{
    int first,second;
    Node(int f,int s){
        first=f;
        second=s;
    }
}
class Solution {    
    public static String cycleDetection(int[][] edges, int vertex, int e) {
        int vis[]=new int[vertex+1]; //Visited array to check if node visited earlier
        ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>(); //Creating adjaceny list
        for(int i=0;i<=vertex;i++){
            ArrayList<Integer> ar= new ArrayList<Integer>();
            adj.add(ar);
        }//adding the lists for every vertex 1 based indexing
        for(int i=0;i<edges.length;i++){
            int a=edges[i][0];
            int b=edges[i][1];
            ArrayList<Integer> temp=adj.get(a);
            temp.add(b);
            ArrayList<Integer> temp2=adj.get(b);
            temp2.add(a);
        }// Taking the pairs from edges matrix and creating the adjacency list
        Queue<Node> q=new LinkedList<Node>();
        Node temp=new Node(1,-1);
        q.add(temp); //Added the first node vertex=1 to the queue with no parent so =-1
        vis[1]=1;
        for(int i=1;i<=vertex;i++){
            if(vis[i]==0)
                {
                Node temp3=new Node(i,-1);
                q.add(temp3);
                vis[i]=1;
            } // for different component adding to queue with parent =-1
            while(!q.isEmpty()){
                Node node=q.poll();
                int n=node.first;
                int par=node.second;
                for(Integer it: adj.get(n)){ //for every adjacent vertex it'll check if visited earlier if yes than if it's the current nodes parent than ok else cycle exists.
                    if(vis[it]==0){
                        Node temp2=new Node(it,n);
                        q.add(temp2);
                        vis[it]=1;
                    }
                    else if(vis[it]==1&&it!=par)
                        return "Yes"; //if cycle exists we return yes
                }
            }
        }
        return "No"; // if whole code runs without a return of yes than cycle didn't exist so we return no.
    }
}

// Time complexity: O(N+E), Where N is the time taken for visiting N nodes and E is for travelling through adjacent nodes.

// Space Complexity:O(N+E)+O(N)+O(N) , Space for adjacency list, Array,Auxiliary space.