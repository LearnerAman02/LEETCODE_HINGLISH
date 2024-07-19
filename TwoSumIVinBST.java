Time Complexity --> O(N)
Space Complexity --> O(N)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void traverse(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        traverse(node.left,list);
        list.add(node.val);
        traverse(node.right,list);
    }
    public boolean findTarget(TreeNode root, int k) {
        //pehlem INORDER TRAVERSAL krke list generate krlo and than uss list ko traverse krke we will goanna find the pair of values 
        //whose sum == target value 
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        //ab iss list mei sorted elements honge hamare paas and just we will need to traverse it and check the pair
        int n = list.size();
        int s = 0;
        int e = n-1;
        //System.out.println("List is : "+list);
        while(s<e){
            //yeh bhi ho sakta hai ki ek individual node ki value = target ki value ho
            // so in that simply return krdo true
            int sum = list.get(s);
            sum += list.get(e);
            if(sum==k){
                return true;
            }
            else if(sum>k){
                sum -= list.get(e);
                e--;
            }
            else{
                sum -= list.get(s);
                s++;
            }
        }
        //agar list mei pair nhi mila toh finally return krdo false
        return false;
    }
}
