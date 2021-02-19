package 每日刷题.两数之和;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;

            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    //数组转链表
    public static ListNode arrayToNode(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode other = head;
        for (int i = 1; i < arr.length; i++) {
            other.next = new ListNode(arr[i]);
            other = other.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = arrayToNode(new int[]{2, 3, 6});
        ListNode l2 = arrayToNode(new int[]{3, 7, 2});
        new Solution().addTwoNumbers(l1,l2);
    }
}