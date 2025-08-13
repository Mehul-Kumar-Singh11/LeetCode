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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> arr = new ArrayList<>();

        // Pushing the values of the first linked list
        while (list1 != null) {
            arr.add(list1.val);
            list1 = list1.next;
        }

        // Pushing the values of the second linked list
        while (list2 != null) {
            arr.add(list2.val);
            list2 = list2.next;
        }

        // Sorting the list
        Collections.sort(arr);

        // Creating a new list with sorted values
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int i = 0; i < arr.size(); i++) {
            curr.next = new ListNode(arr.get(i));
            curr = curr.next;
        }

        return dummy.next;
    }
}