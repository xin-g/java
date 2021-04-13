package 每日刷题.最大数;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式），调用Arras.sort()
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            // 将两个数组换成相同的分位
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }

            // 这样可以比较2位以上其他低位
            int a = (int) (-sy * x - y + sx * y + x);
            return a;
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        // 转换成字符串
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = new Solution().largestNumber(new int[]{900,5,81,4});
        System.out.println(s);
    }
}
