package 每日刷题.翻转图像;

import java.util.Arrays;

public class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int x = A.length;
        int y = A[0].length;
        for (int i = 0; i < x; i++) {
            int left = 0,right = y - 1;
            while (left < right){
                A[i][left] = A[i][left] ^ A[i][right];
                A[i][right] = A[i][left] ^ A[i][right];
                A[i][left] = A[i][left] ^ A[i][right];

                A[i][left] ^= 1;
                A[i][right] ^= 1;

                left++;
                right--;
            }
            if (left == right){
                A[i][left] ^= 1 ;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 1,1, 0, 0}, {1, 0,1, 0, 1}, {0, 1,1, 1, 1}, {1, 0,1, 1, 0}};
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        System.out.println();
        int[][] ints = new Solution().flipAndInvertImage(array);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }

    }
}
