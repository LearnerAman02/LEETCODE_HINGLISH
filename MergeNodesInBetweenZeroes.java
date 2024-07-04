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

NOTE --> Try to visualize by writing with PEN and PAPER while reading the LOGIC
class Solution {
    public ListNode mergeNodes(ListNode head) {
        //pehle starting ke zeroes ko skip kro
        if(head==null || head.next==null){
            return null;
        }
        ListNode temp1 = head;
        ListNode temp2 = head.next;

        //leading 0's ko skip krte jaao
        //so that aage wala ptr non zero wale node pe jaake ruke
        while(temp2.val==0){
            temp2 = temp2.next;
        }

        int sum =0;
        //temp2 ko tab tak chalao jab tak null pe nhi reach krta 
        while(temp2!=null){
            //now check if temp2 has reached the node with value 0
            //if yes than update the node value jispe temp1 ptr point kr raha with sum value and reinitialize sum to 0 aur usko phir aage badhao if temp2.next != null, else usko bhi null krdo kyunki aage newnodes milna possible nhi
            // else temp2 agar non zero node pe hai toh uski value ko sum mei add krdo 
            if(temp2.val==0){
                temp1.val = sum;
                sum = 0;
                if(temp2.next==null){
                    temp1.next=null;
                }
                else{
                    temp1 = temp1.next;
                }
            }
            else{
                sum += temp2.val;
            }
            temp2 = temp2.next;
        }
        
        return head;
    }
}

//T.C. --> O(N)
//S.C. --> O(1)
//pblm link --> 
