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
    public ListNode middleNode(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Brute Approach
    /* 
     public ListNode middleNode(ListNode head) {
        int size = getSize(head);
        int halfSize = ( size / 2) + 1;
        int temp = 1;
        ListNode curr = head;
        while(temp != halfSize) {
            curr = curr.next;
            temp++;
        }
        return curr;
    }
    public int getSize(ListNode head) {
        ListNode curr = head;
        int size = 0;
        while(curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }
    */
}