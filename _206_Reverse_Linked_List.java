/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode fast = head;
        ListNode tmp = null;
        while(fast.next != null){
            tmp = fast.next;
            fast.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}
