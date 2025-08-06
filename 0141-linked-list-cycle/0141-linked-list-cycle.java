/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> st = new HashSet<>();

        while (head != null) {

            // If this node is already present
            // in hashmap it means there is a cycle
            if (st.contains(head))
                return true;

            // If we are seeing the node for
            // the first time, insert it in hash
            st.add(head);

            head = head.next;
        }
        return false;
    }
}