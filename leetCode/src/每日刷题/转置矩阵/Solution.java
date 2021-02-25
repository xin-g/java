package 每日刷题.转置矩阵;

import java.util.Arrays;

public class Solution {
    public int[][] transpose(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] matrixT = new int[y][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrixT[j][i] = matrix[i][j];
            }
        }
        return matrixT;
    }

    public static void main(String[] args) {
        int[][] transpose = new Solution().transpose(new int[][]{{1, 2, 3}, {4, 5, 6}});
        for (int i = 0; i < transpose.length; i++) {
            System.out.println(Arrays.toString(transpose[i]));
        }
    }
}
