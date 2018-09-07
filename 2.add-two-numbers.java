/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;

            int sum = v1 + v2 + carry;

            ListNode cur = new ListNode(sum % 10);
            carry = sum / 10;
            
            p.next = cur;
            p = cur;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if(carry != 0){
            ListNode cur = new ListNode(carry);
            p.next = cur;
        }

        return dummy.next;
    }
}
