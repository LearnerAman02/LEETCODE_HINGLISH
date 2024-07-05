// T.C. --> O(n)
// S.C. --> O(1)
//pblm link --> https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/?envType=daily-question&envId=2024-07-05
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        //edge cases ko tackle kr lo
        if(head==null || head.next==null || head.next.next==null){
            return ans;
        }
        ListNode prevNode = head;//ek se pichhe chalega current node se
        //current node hamara woh node hoga jispe hum MINIMA/MAXIMA check krna chahte hai
        ListNode curr = head.next;
        ListNode nextNode = head.next.next;
        int count = 2;//initial position of current node
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //pMin and pMax variable bana rahe hai so that minimum and maximum difference find kr sake between the CRITICAL POINTS
        //yaha pe one of the important thing ye bhi hai ki aap kaise minimum difference value and maximum difference value calculate krte ho using pMin and pMax variable
        int pMin = 0;
        int pMax = 0;
        boolean first = false;//max difference ke liye ek flag variable bana rahe hai so that sabse first critical point ko prevserve kr sake
        while(nextNode !=null){
            //check for local maxima
            if(curr.val>prevNode.val && curr.val>nextNode.val){
                if(pMin!=0){
                    min = Math.min(count-pMin,min);
                }
                pMin = count;
                if(!first){
                    pMax = count;
                    first = true;
                }
                max = Math.max(count-pMax,max);
            }
            //check for LOCAL MINIMA
            if(curr.val<prevNode.val && curr.val<nextNode.val){
                if(pMin!=0){
                    min = Math.min(count-pMin,min);
                    //System.out.println("Min : "+min);
                }
                pMin = count;
                if(!first){
                    pMax = count;
                    first = true;
                }
                max = Math.max(count-pMax,max);
            }
            count++;
            prevNode = curr;
            curr = nextNode;
            nextNode = nextNode.next;
        }
        //agar min and max ki value update nhi hui than iska matlab hai ki maxima and minima nhi mila OR more than 1 critical points nhi mile,  toh simply [-1,-1] array return kr do
        if(max==Integer.MIN_VALUE || min == Integer.MAX_VALUE){
            return ans;
        }
        ans[0] = min;
        ans[1] = max;
        return ans;
    }
}
