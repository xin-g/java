package 补充.基本计算器;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n){
            if(s.charAt(i) == ' '){
                i++;
            }else if (s.charAt(i) == '+'){
                sign = ops.peek();
                i++;
            }else if (s.charAt(i) == '-'){
                sign = -ops.peek();
                i++;
            }else if (s.charAt(i) == '('){
                ops.push(sign);
                i++;
            }else if (s.charAt(i) == ')'){
                ops.pop();
                i++;
            }else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public int calculate1(String s){
        Deque<Integer> ops = new LinkedList<>();
        int sign = 1;
        ops.push(1);
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)){
                case ' ':
                    i++;
                    break;
                case '+':
                    sign = ops.peek();
                    i++;
                    break;
                case '-':
                    i++;
                    sign = -ops.peek();
                    break;
                case '(':
                    ops.push(sign);
                    i++;
                    break;
                case ')':
                    ops.pop();
                    i++;
                default:
                    long num = 0;
                    while (i < n && Character.isDigit(s.charAt(i))){
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    res += num;
            }
        }
        return res;
    }

}
