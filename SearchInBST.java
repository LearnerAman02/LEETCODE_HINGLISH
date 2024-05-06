//pblm link --> https://leetcode.com/problems/search-in-a-binary-search-tree/description/
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
    TreeNode left = null;
    //TreeNode right = null;
    public TreeNode searchBST(TreeNode root, int val) {
        //BST mein agar currNode se chhoti hai target node ki value than LEFT SUBTREE mein jaao
        //BST mein agar currNode se bigger hai target node ki value than RIGHT SUBTREE mein jaao
        if(root==null){
            return null;
        }
        if(val==root.val){
            return root;
        }
        if(val<root.val){
            left = searchBST(root.left,val);
        }
        if(val>root.val){
            left = searchBST(root.right,val);
        }
        return left;
    }
}
