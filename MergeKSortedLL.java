//T.C. --> O(N*M)
// N --> for traversing the lists array and M --> for traversing the each LL at index i
//S.C. --> O(N+M) {creation og NEW NODES and MIN HEAP}
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
    ListNode head = null;
    public ListNode mergeKLists(ListNode[] lists) {
        //simply MIN HEAP se kar sakte hai and just hume LL ko traverse krna hai properly
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            ListNode current = lists[i];//array LL ki hai toh current naam ka variable create karenge jiska type bhi LL hoga
            //than simply current index pe jo LL hai usko traverse karenge and uski value ko MIN HEAP mei put karenge
            while(current!=null){
                pq.offer(current.val);
                current = current.next;
            }
        }
        //assign Head node first
        if(!pq.isEmpty()){
            ListNode newNode = new ListNode(pq.poll());
            head = newNode;
        }
        ListNode temp = head;
        while(!pq.isEmpty()){
            //now simple logic of inserting a NEW NODE in LL
            ListNode newNode = new ListNode(pq.poll());
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }
}
