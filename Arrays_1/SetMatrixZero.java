// import java.util.*;
class Solution {
    public static void setZeroes(int[][] matrix) {
        int col0 = 1;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++){
            if (matrix[i][0] == 0){
                col0 = 0;
            }
            for (int j = 1; j < col; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--){
            for (int j = col - 1; j >= 1; j--){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0){
                matrix[i][0] = 0;
            }
        }
    }
    public static void main(String args[]) {
        int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(arr);
        System.out.println("The Final Matrix is ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        System.out.println();
   }
}
}

// Time Complexity: O(2*(N*M)), as we are traversing two times in a matrix,
// Space Complexity: O(1).