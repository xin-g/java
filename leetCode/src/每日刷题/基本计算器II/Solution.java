package 每日刷题.基本计算器II;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1){
                switch (preSign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                        break;
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
