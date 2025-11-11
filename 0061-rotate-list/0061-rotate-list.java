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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        k = k % size;
        if(k == 0) return head;

        ListNode temp = head;
        ListNode newHead = null;
        while (temp.next != null) {
            size--;
            if (size == k)
                break;
            temp = temp.next;
        }
        newHead = temp.next;
        temp.next = null;

        // temp = newHead;
        // while (temp.next != null) {
        //     temp = temp.next;
        // }
        tail.next = head;

        return newHead;
    }
}