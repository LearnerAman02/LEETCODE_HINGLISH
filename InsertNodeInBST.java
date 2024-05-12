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
 Logic -->
 Pehle root node se compare krlo ki kaunse subtree mei node will be inserted kyunki BST hai, than uske basis pe simply Left subtree yaa right subtree ke liye RECURSIVE CALLS lagado
Ab har ek call mein just aapko ye cheez check karni hai
//BASE CASE --> node agar null hai toh simply return kar jaao
Current Node ka left agar null hai aur hamare node to be inserted ki value agar < current node ka value hai than simply currentNode ka left new node krdo and return kar jaao

nhi toh agar Current node ka right null hai aur current node ki value < new node to be inserted ki vakue hai than iss case mei just current node ke right mein new node insert krdo and than return kr jaao

//RECUSRIVE CALLS CONDITION -->
1 - Agar new node ka val > current node ka value than currnode.right krdo in recursive function
2 - Agar new node ka val < current node ka value than currnode.left krdo in recursive function
 */
class Solution {
    public void insertNode(TreeNode node,int val){
        if(node==null){
            return;
        }
        if(node.left==null && node.val>val){
            node.left = new TreeNode(val);
            return;
        }
        if(node.right==null && node.val<val){
            node.right = new TreeNode(val);
            return;
        }
        if(node.val>val){
            insertNode(node.left,val);
        }
        if(node.val<val){
            insertNode(node.right,val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            root = new TreeNode(val);
            return root;
        }
        insertNode(root,val);
        return root;
    }
}
