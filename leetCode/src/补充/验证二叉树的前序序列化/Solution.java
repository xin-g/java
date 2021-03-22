package 补充.验证二叉树的前序序列化;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    // 不对
    public boolean isValidSerialization1(String preorder) {
        if (preorder == null || preorder.equals("")){
            return false;
        }
        String[] split = preorder.split(",");
        Stack<Integer> stack = new Stack<>();
        int n = split.length;
        int i = 0;
        if (!split[i].equals("#")){
            stack.push(1);

        }
        i++;
        while (i < n){
            if (split[i].equals("#")){
                if (stack.size() == 0){
                    return false;
                }
                stack.push(stack.pop() - 1);
                stackZero(stack);
            }else {
                stack.push(2);
            }
            i++;
        };
        if (stack.isEmpty()){
            return true;
        }

        return false;
    }

    public void stackZero(Stack<Integer> stack){
        if (stack.peek() == 0){
            stack.pop();
            if (!stack.isEmpty()){
                stack.push(stack.pop() - 1);
            }else {
                return;
            }

            if (stack.peek() == 0){
                stackZero(stack);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean validSerialization = solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#,#");
        System.out.println(validSerialization);
    }


    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

}
