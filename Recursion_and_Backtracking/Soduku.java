import java.io.*;
import java.util.*;

public class Soduku {

    public static boolean isItSudoku(int matrix[][]) {
        return solve(matrix);

    }

    public static boolean solve(int matrix[][]) {
        int i, j;
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int c = 1; c <= 9; c++) {
                        if (isvalid(matrix, i, j, c)) {
                            matrix[i][j] = c;
                            if (solve(matrix) == true) {
                                return true;
                            } else {
                                matrix[i][j] = 0;
                            }

                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isvalid(int matrix[][], int r, int c, int val) {
        int i;
        for (i = 0; i < 9; i++) {
            if (matrix[r][i] == val)
                return false;
            if (matrix[i][c] == val)
                return false;
            if (matrix[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == val)
                return false;
        }
        return true;
    }
}