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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Base cases
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        // Step-1. Find the middle node that will be our root
        ListNode slow = head;
        ListNode fast = head;
        ListNode prevSlow = null;
        while(fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // here,slow pointer will be pointing to root of the Tree
        TreeNode root = new TreeNode(slow.val);
        // Step-2. Recursively call sortedListToBST for root.left (here, have to update the root prev node pointing to null)
        prevSlow.next = null;
        root.left = sortedListToBST(head);
        // Step-2. Recursively call sortedListToBST for root.right
        root.right = sortedListToBST(slow.next);

        return root;
    }
}