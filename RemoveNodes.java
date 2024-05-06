//pblm link --> https://leetcode.com/problems/remove-nodes-from-linked-list/?envType=daily-question&envId=2024-05-06

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

 BRUTE FORCE LOGIC --> Linked list ko traverse karke array mei put kardo and than uss array ko traverse karke stack mein NEXT GREATER ELEMENT wala concept use karo
T.C. --> O(N) 
S.C. --> O(N)
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }
        int len = list.size();
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<len;i++){
            int curr = list.get(i);
            while(!s.isEmpty() && s.peek()<curr){
                s.pop();
            }
            s.push(curr);
        }
        int l = s.size();
        int reverse[] = new int[l];
        //now array mein reverse way se store karao and than usko traverse karke LL banado final
        for(int i=0;i<l;i++){
            reverse[l-i-1] = s.pop(); 
        }
        //now iss array ko traverse krke final LL create karo
        if(l!=0){
            head = new ListNode(reverse[0]);
        }
        temp = head;
        for(int i=1;i<l;i++){
            temp.next = new ListNode(reverse[i]);
            temp = temp.next;
        }
        return head;
    }
}
