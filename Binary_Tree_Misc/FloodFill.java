public class FloodFill {
    void dfs(int i, int j, int[][] image, int n, int m, int newCol, int oldCol){
        if (i < 0 || j < 0 || i >= n || j >= m){
            return;
        }
        if (image[i][j] != oldCol || image[i][j] == newCol){
            return;
        }
        image[i][j] = newCol;
        dfs(i+1, j, image, n, m, newCol, oldCol);
        dfs(i-1, j, image, n, m, newCol, oldCol);
        dfs(i, j+1, image, n, m, newCol, oldCol);
        dfs(i, j-1, image, n, m, newCol, oldCol);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int oldCol = image[sr][sc];
        dfs(sr, sc, image, n, m, color, oldCol);
        return image;
    }
}
