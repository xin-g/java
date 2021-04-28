package 每日刷题.平方数之和;

public class Solution {
    /**
     * 方法一：使用sqrt函数
     * @param c
     * @return
     */
    public boolean judgeSquareSum1(int c) {
        for (int a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if(b == (int) b){
                return true;
            }
        }
        return false;
    }

    /**
     * 方法二：双指针
     * @param c
     * @return
     */
    public boolean judgeSquareSum2(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right){
            long sum = (long) (Math.pow(left,2) + Math.pow(right,2));
            if (sum == c){
                return true;
            }else if(sum > c){
                right--;
            }else {
                left++;
            }
        }
        return false;
    }

    /**
     * 费马平方和定理告诉我们：
     * 一个非负整数 c 如果能够表示为两个整数的平方和，当且仅当 c 的所有形如 4k + 3 的质因子的幂均为偶数。
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        for (int base = 2; base * base <= c; base++) {
            // 如果不是因子，枚举下一个
            if (c % base != 0) {
                continue;
            }

            // 计算 base 的幂
            int exp = 0;
            while (c % base == 0) {
                c /= base;
                exp++;
            }

            // 根据 Sum of two squares theorem 验证
            if (base % 4 == 3 && exp % 2 != 0) {
                return false;
            }
        }

        // 例如 11 这样的用例，由于上面的 for 循环里 base * base <= c ，base == 11 的时候不会进入循环体
        // 因此在退出循环以后需要再做一次判断
        return c % 4 != 3;
    }
}
