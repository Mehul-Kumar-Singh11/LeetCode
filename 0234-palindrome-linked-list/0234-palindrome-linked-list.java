/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head, fast = head;

        while (fast.next != null 
               && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverseList(slow.next);
        slow.next = null;

        boolean ret = isIdentical(head, head2);

        head2 = reverseList(head2);
        slow.next = head2;

        return ret;
    }

    ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    boolean isIdentical(ListNode n1, ListNode n2) {
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val)
                return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }
}