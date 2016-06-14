/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode ret = new ListNode(0);
        ListNode pre = ret;
        while(l1!=null||l2!=null){
            int c1 = l1 ==null?0:l1.val;
            int c2 = l2 ==null?0:l2.val;
            int sum = c1+c2+carry;
            ListNode cur = new ListNode(sum%10);
            carry = sum/10;
            pre.next = cur;
            pre = cur;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
        }
        if(carry!=0){
            ListNode cur = new ListNode(carry);
            pre.next=cur;
        }
        return ret.next;
    }
}