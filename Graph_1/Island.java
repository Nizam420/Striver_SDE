class Solution 
{
   public static int getTotalIslands(int[][] grid) 
{
       int count = 0;
       for(int i=0;i<grid.length;i++){
           for(int j=0;j<grid[0].length;j++){
               if(grid[i][j]==1){
                   count++;
                   dfs(grid,i,j);
               }
           }
       }
       return count;
   }
    public static void dfs(int[][] grid, int i, int j){
       int dirs[][] = {{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0}};
       for(int idx=0;idx<8;idx++){
           int ii = i + dirs[idx][0];
           int jj = j + dirs[idx][1];
            if(ii<0 || jj<0 || ii>=grid.length || jj>=grid[0].length || grid[ii][jj]==0){
               continue;
            }
            grid[ii][jj]=0;
            dfs(grid,ii,jj);
       }
   }
}
// Time Complexity: O(N+E) 

// N = Number of node , E = Number of Edges

// Space Complexity: O(N) + O(N)

// Visited Array and Stack data structure. Both will be using O(N).

// Auxiliary Space Complexity:  O(N)