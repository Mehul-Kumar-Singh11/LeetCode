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
    public ListNode insertionSortList(ListNode head) {
        List<Integer> lis = new ArrayList<>();

        // extract values
        while (head != null) {
            lis.add(head.val);
            head = head.next;
        }

        // sort the values
        Collections.sort(lis);

        // rebuild sorted list
        ListNode node = new ListNode(lis.get(0));
        ListNode temp = node;

        for (int i = 1; i < lis.size(); i++) {
            ListNode newNode = new ListNode(lis.get(i));
            temp.next = newNode;
            temp = newNode;
        }

        return node;
    }
}