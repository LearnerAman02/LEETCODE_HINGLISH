//T.C. --> O(logn)
//S.C. --> O(1)
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        //pehle check krlo ROOT null toh nhi hai
        //agar hai than simly newNode create krdo, and make it a ROOT
        if(root==null){
            root = newNode;
            return root;
        }
        else{
            //means root exist krta hai
            //toh first just make a check if the value to be inserted is > than current node ka value than simply
            //go to RIGHT SUBTREE 
            if(root.val<val){
                if(root.right == null){
                    //if current node ka right is NULL than it is the place to put the newNode
                    root.right = newNode;
                    return root;
                }
                else if(root.right!=null){
                    //else keep on going deeper in the RIGHT SUBTREE till u get current Node ka right is NULL
                    TreeNode n = insertIntoBST(root.right,val);
                }
            }
            else{
                //root.val>key
                //now just make a check if the value to be inserted is < than current node ka value than simply
                //go to LEFT SUBTREE 
                if(root.left == null){
                    root.left = newNode;
                    return root;
                }
                else if(root.left!=null){
                    //else keep on going deeper in the LEFT SUBTREE till u get current Node ka left is NULL
                    TreeNode n = insertIntoBST(root.left,val);
                }
            }
        }
        return root;
    }
}
