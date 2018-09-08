/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }

        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;

        copyNode(head);
        copyRandom(head);
        return splitList(head);
        
    }

    private void copyNode(RandomListNode head){
        RandomListNode p = head;
        while(p != null){
            RandomListNode pCopy = new RandomListNode(p.label);
            RandomListNode next = p.next;
            p.next = pCopy;
            pCopy.next = next;
            p = next;
        }
    }

    private void copyRandom(RandomListNode head){
        RandomListNode p = head;
        while(p != null){
            RandomListNode pCopy = p.next;
            pCopy.random = p.random == null ? null : p.random.next;
            p = pCopy.next;
        }
    }

    private RandomListNode splitList(RandomListNode head){
        RandomListNode copyHead = head.next;
        RandomListNode p = head;
        RandomListNode pCopy = copyHead;
        while(p != null){
            p.next = pCopy.next;
            pCopy.next = p.next == null ? null : p.next.next;
            p = p.next;
            pCopy = pCopy.next;
        }

        return copyHead;
    }
}
