/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public class QueueNode implements Comparable<QueueNode>{
        public Integer val;
        public Integer position;
        public QueueNode(int v, int p){
            this.val = v;
            this.position = p;
        }
        public int compareTo(QueueNode other){
            return this.val.compareTo(other.val);
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        PriorityQueue<QueueNode> queue = new PriorityQueue<>();
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                queue.add(new QueueNode(lists[i].val, i));
                lists[i] = lists[i].next;
            }
        }
        while(!queue.isEmpty()){
            QueueNode minNode = queue.poll();
            int pos = minNode.position;
            int val = minNode.val;
            if(lists[pos] != null){
                queue.add(new QueueNode(lists[pos].val, pos));
                lists[pos] = lists[pos].next;
            }
            ListNode newNode = new ListNode(val);
            tail.next = newNode;
            tail = tail.next;
        }
        return dummy.next;
    }
}
