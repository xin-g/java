package 每日刷题.无重复字符的最长字串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Solution {
    /**
     * 1、使用两个指针，左指针代表字串的起始位置，右指针代表字串的结束位置——rk；
     * 2、在每一步操作中，我们会将左指针向右移动一格，表示我们开始枚举下一个字符作为起始位置，
     * 然后我们不断向右移动右指针，但需要保证这两个指针的字串没有重复字符，这个操作结束后，我们
     * 就记录下这个字串的长度。
     * 3、枚举结束后，找到最长的字串长度。
     * 时间复杂度：O(N)
     */
    public int lengthOfLongestSubstring(String s){
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int rk = -1,ans = 0;
        for (int i = 0; i < n; i++) {
            if(i != 0){
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))){
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans,rk - i + 1);
        }
        return ans;
    }

    /**
     * 什么是滑动窗口？
     * 其实就是一个队列，比如列题中的 abcabcbb，进入这个队列（窗口）为abc满足题目要求，
     * 当在进入a，队列变成了abca，这时候不满足要求。所以，要移动这个队列
     * 如何移动？
     * 只要把队列的左边的元素移出就行了，直到满足要求！
     * 一直维持这样的队列，找出队列出现最长的长度时候，返回结果！
     * 时间复杂度：O(N)
     */
    public int lengthOfLongestSubstring1(String s) {
        if(s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int abcabcbb = new Solution().lengthOfLongestSubstring1("abcabcbb");
        System.out.println(abcabcbb);
    }
}
