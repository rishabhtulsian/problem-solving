/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        if (curr != null) {
            int c = curr.val;
            while (curr.next != null) {
                if (curr.next.val == c) {
                    curr.next = curr.next.next;
                } else {
                    c = curr.next.val;
                    curr = curr.next;
                }
            }
        }
        return head;
    }
}