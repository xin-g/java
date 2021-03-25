package 每日刷题.删除排序链表中的重复元素II;

import 每日刷题.两数之和.ListNode;

public class Solution {
    public ListNode deleDuplicates(ListNode head){
        if (head == null){
            return head;
        }

        // 设一个哑节点，防止头节点不被删
        ListNode dummy = new ListNode(0,head);

        // 另设一个遍历的坐标
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
