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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = 0;
        ListNode curr = head;
        
        // Find length of  list 
        while (curr != null) {
            curr = curr.next;
            k++;
        }
        
        // if head is the nth node from end 
        if (k - n == 0) return head.next;
        
        // Reach the node just before
        // the target node.
        curr = head;
        for (int i = 1; i < k - n; i++) {
            curr = curr.next;
        }

        // Skip the target node
        curr.next = curr.next.next;

        return head;
    }
}