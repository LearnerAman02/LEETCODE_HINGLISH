/**
//pblm link --> https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/description/?envType=daily-question&envId=2024-05-07
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 LOGIC --> LL ko reverse kar do and than 2 multiply karke check karo ki kahi carry toh generate nhi ho raha hai
 if CARRY IS GENERATED agle wale number mei carry ko add krdo , if NO CARRY just number ko double krke currNode mei place krde

 */
class Solution {
    public ListNode doubleIt(ListNode head) {
        //pehle reverse krlo LL ko
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        //now LL ko traverse krna start kro and value ko 2 se multiply karke place karo
        ListNode temp = prev;
        int carry = 0;
        ListNode preNode = null;
        while(temp!=null){
            int num = temp.val*2 + carry;
            temp.val = num%10;
            carry = num/10;
            preNode = temp;
            temp = temp.next;
        }
        //now phir se reverse krdo
        ListNode temp3 = prev;//sabse last node ko point karado of the modified LL
        //i.e. - 9-->9-->9-->null
        //                       p(prev)
        //modified - 1-->9-->9-->8-->null
        //now bas isi LL ke prev ko hume point krna hai, so that hum LL ko reverse kr sake
        // while(temp3!=null){
        //     System.out.println(temp3.val+"-->");
        //     temp3 = temp3.next;
        // }
        if(carry>0){
            ListNode newNode = new ListNode(1);
            preNode.next = newNode;
            preNode = newNode;
        }
        ListNode prev1 = null;
        curr = prev;
        while(curr!=null){
            ListNode temp1 = curr.next;
            curr.next = prev1;
            prev1 = curr;
            curr = temp1;
        }
        return prev1;
    }
}
