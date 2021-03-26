package 每日刷题.删除排序链表中的的重复元素;

import 每日刷题.两数之和.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode cur = head;
        while (cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }
}
