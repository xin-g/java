package 每日刷题.猜字谜;

import java.util.*;

public class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        Map<Integer,Integer> frequency = new HashMap<>();

        for(String word : words){
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7){
                frequency.put(mask,frequency.getOrDefault(mask,0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (String puzzle : puzzles){
            int total = 0;

            // 枚举子集方法一
//            for (int choose = 0; choose < (1 << 6); choose++) {
//                int mask = 0;
//                for (int i = 0; i < 6; i++) {
//                    mask |= (1 << (puzzle.charAt(i + 1) - 'a'));
//                }
//                mask |= (1 << (puzzle.charAt(0) - 'a'));
//                if (frequency.containsKey(mask)){
//                    total += frequency.get(mask);
//                }
//            }

            // 枚举子集方法二
            int mask = 0;
            for (int i = 0; i < 7; i++) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;
            do{
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                if(frequency.containsKey(s)){
                    total += frequency.get(s);
                }
                subset = (subset - 1) & mask;
            }while (subset != mask);
            ans.add(total);
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().findNumOfValidWords(new String[]{"aaaa","asas","able","ability","actt","actor","access"},
                new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"});
    }
}
