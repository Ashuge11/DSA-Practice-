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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode last = head;
        while(last != null){
         n++;
         last = last.next;
        }
        int part = n / k ;
        int extra = n % k;
        ListNode[] result = new ListNode[k];
        ListNode curr = head;
    
        for(int i=0; i<k; i++){
             result[i] = curr;
             int currentsize = part + (extra > 0 ? 1 : 0);
             if(extra > 0){
                extra--;
             }
             for(int j=1; j<currentsize; j++){
                curr = curr.next;
             }
             if(curr != null){
                ListNode prev = curr.next;
                curr.next = null;
                curr = prev;
             }
        }
        return result;
    }
}
