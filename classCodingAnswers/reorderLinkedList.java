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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
        }

        ListNode curr = slow.next;
        slow.next=null;
        ListNode prev = null;

        while(curr != null){
            ListNode backup = curr.next;
            curr.next = prev;
            prev=curr;
            curr = backup;
        }

        while(prev!=null && head!=null){
            ListNode temp1 = head.next;
            head.next = prev;
            head = temp1;
            ListNode temp2 = prev.next;
            prev.next = temp1;
            prev = temp2;
        }
    }
}
