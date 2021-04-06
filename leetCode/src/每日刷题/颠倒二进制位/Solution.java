package 每日刷题.颠倒二进制位;

public class Solution {

    /*
     方法一：逐位颠倒
     时间复杂度：O(log n)
     空间复杂度：O(1)
     */
    public int reverseBits(int n){
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    private static final int M1 = 0x55555555;
    private static final int M2 = 0x33333333;
    private static final int M4 = 0x0f0f0f0f;
    private static final int M8 = 0x00ff00ff;

    /*
     位运算分治
     时间复杂度：O(1)
     空间复杂度：O(1)
     */
    public int reverseBits2(int n){
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;

        return n >>> 16 | n << 16;
    }

    public static void main(String[] args) {
        int i = new Solution().reverseBits(5);
        System.out.println("结果：" + Integer.toBinaryString(i));
    }
}
