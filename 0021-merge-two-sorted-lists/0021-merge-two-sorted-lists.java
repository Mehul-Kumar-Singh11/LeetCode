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
import java.util.LinkedList;
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        while(temp1 != null && temp2 != null) {
            if(temp1.val > temp2.val) {
                current.next = temp2;
                temp2 = temp2.next;
            }
            else {
                current.next = temp1;
                temp1 = temp1.next;
            }
            current = current.next;
        }
        
        while(temp1 != null) {
            current.next = temp1;
            temp1 = temp1.next;
            current = current.next;
        }
        while(temp2 != null) {
            current.next = temp2;
            temp2 = temp2.next;
            current = current.next;
        }
        return dummy.next;
    }
}