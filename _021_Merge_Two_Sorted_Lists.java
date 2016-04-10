/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode head = null;
        ListNode tail = null;
        while(l1 != null || l2 != null){
            int val = 0;
            if(l1 == null){
                val = l2.val;
                l2 = l2.next;
            }else if(l2 == null){
                val = l1.val;
                l1 = l1.next;
            }else{
                if(l1.val <= l2.val){
                    val = l1.val;
                    l1 = l1.next;
                }else{
                    val = l2.val;
                    l2 = l2.next;
                }
            }
            ListNode newNode = new ListNode(val);
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = tail.next;
            }
        }
        return head;
    }
}
