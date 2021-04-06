package 每日刷题.旋转链表;

import 每日刷题.两数之和.ListNode;

public class Solution {
    /*
    闭合为环
    时间复杂度：O(n)
    空间复杂度：O(1)
     */
    public ListNode rotateRight(ListNode head,int k){
        if (k == 0 || head == null || head.next == null){
            return head;
        }
        int n = 1;

        // 链表的位置
        ListNode iter = head;

        // 找到链表的最后一个,同时记录节点的个数
        while (iter.next != null){
            iter = iter.next;
            n++;
        }
        // 要旋转的节点个数
        int add = n - k % n;

        // 选择的个数等于节点个数，相当于没有旋转
        if(add == n){
            return head;
        }
        // 链表首尾连接
        iter.next = head;

        // 将标记移动到要断开的位置
        while (add-- > 0){
            iter = iter.next;
        }

        // 创建一个新的链表，赋值，并断开链表
        ListNode ret = iter.next;
        iter.next = null;
        return ret;

    }
}
