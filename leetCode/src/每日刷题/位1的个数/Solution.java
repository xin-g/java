package 每日刷题.位1的个数;

public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if((n & (1 << i)) != 0){
                res++;
            }
        }
        return res;
    }

    // 方法2
    public int hammingWeight1(int n) {
        int res = 0;
        while (n != 0){
            n &= n - 1;
            res++;
        }
        return res;
    }
}
