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
    public void preorder(TreeNode n,List<TreeNode> l){
        if(n==null){
            return;
        }
        l.add(n);
        preorder(n.left,l);
        preorder(n.right,l);
    }
    public void flatten(TreeNode root) {
        //traverse krna start kro and List create kr lo of the PRE ORDER traversal 
        //and than node.left NULL krdo and node.right list ke andar next node ko krdo
        List<TreeNode> list = new ArrayList<>();
        preorder(root,list);
        if(list.size()==0){
            return;
        }
        int n = list.size();
        root = list.get(0);
        root.left = null;
        TreeNode temp = root;
        for(int i=1;i<n;i++){
            temp.right = list.get(i);
            temp.left = null;
            temp = temp.right;
        }
    }
}
