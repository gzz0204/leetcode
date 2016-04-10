/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        // if we cannot modify the parameter
        int len = 0;
        ListNode pivot = head;
        while(pivot != null){
            len ++;
            pivot = pivot.next;
        }
        if(len <= 1){
            return true;
        }
        int[] vals = new int[len];
        for(int i = 0; i < len; i++){
            vals[i] = head.val;
            head = head.next;
        }
        if(len % 2 == 0){
            int mid = len / 2 - 1;
            int expand = 0;
            while(mid-expand >= 0){
                if(vals[mid-expand] != vals[mid+expand+1]){
                    return false;
                }
                expand ++;
            }

        }else{
            int mid = len / 2;
            int expand = 1;
            while(mid-expand >= 0){
                if(vals[mid-expand] != vals[mid+expand]){
                    return false;
                }
                expand ++;
            }
        }
        return true;
    }
    public boolean isPalindrome2(ListNode head) {
        // if we can modify the parameter
        int len = 0;
        ListNode pivot = head;
        while(pivot != null){
            len ++;
            pivot = pivot.next;
        }
        if(len <= 1){
            return true;
        }
        int mid = 0;
        if(len % 2 == 0){
            mid = len / 2;
        }else{
            mid = (len / 2) + 1;
        }
        ListNode midPivot = head;
        for(int i = 1; i < mid; i++){
            midPivot = midPivot.next;
        }
        pivot = head;
        if( len % 2 == 0){
            midPivot = midPivot.next;
        }
        pivot = head;
        ListNode tmpNode = head;
        while(pivot.next != midPivot){
            tmpNode = pivot.next;
            pivot.next = tmpNode.next;
            tmpNode.next = head;
            head = tmpNode;
        }
        if( len % 2 != 0 ){
            midPivot = midPivot.next;
        }
        tmpNode = midPivot;
        pivot = head;
        while(tmpNode != null){
            if(tmpNode.val != pivot.val){
                return false;
            }
            tmpNode = tmpNode.next;
            pivot = pivot.next;
        }
        return true;

    }
}
