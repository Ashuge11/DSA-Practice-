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
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int n = 1;
        ListNode last = head;
        while(last.next != null){
            n++;
            last = last.next;
        }
        k = k % n;
        int steps = n-k;
        last.next = head;
        ListNode newlast = head;
        for(int i=1; i<steps; i++){
            newlast = newlast.next;
        }
        ListNode newhead = newlast.next;
        newlast.next = null;
        return newhead; 
    }
}
