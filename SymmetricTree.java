//pblm link --> https://leetcode.com/problems/symmetric-tree/
/*
Logic -->
 Ek tree ko symmetric hum uss case mein bolenge jab hum root NODE pe ek vertical line draw kare and uss line ke about LEFT SUBTREE and RIGHT SUBTREE ek doosre ke mirror image ho
 Now ye cheez ko tree traversal se how can we identify


         5 (root node)
       /   \
      1      1
     / \    /  \
    2   3  3    2

ab hum 2 pointers lenge , (leftnode, rightnode) and inme leftnode ptr se we will traverse left subtree and rightnode ptr se we will traverse right subtree
agar hum dono pointers ki value ko compare karenge har ek baar 
and NOTE --> Hum left subtree ke currentNode ke rightnode ke value ko check karenge with  currentNode ke leftnode ke value se
and vice versa
BECAUSE MIRROR IMAGE hai so jo leftnode hoga current node ka yaha pe , waha pe wahi node currnode ke right mein hoga

so wahi normal recursive way mein traverse karenge and modification for next node opposite opposite karenge
agar leftnode next call mein right node ko point kar raha hai than rightnode will point to left node and VICE VERSA
baaki hume recursion pe faith rakhna hai ki woh har ek node ko properly check karega and will give us the RIGHT ANSWER

         5 (root node)
       /   \
left  1      1 right
     / \    /  \
    2   3  3    2
    CASE 1 --> ab next call left.left agar left subtree mein laga raha hoon than right.right lagaunga in right subtree
           5 (root node)
         /   \
        1      1 
       / \    /  \
 left 2   3  3    2 right  --> dekho left node of left subtree and right node of right subtree ko hume compare krna because mirror image about root hai yaa nhi iske liye

CASE 2 --> ab next call left.right agar left subtree mein laga raha hoon than right.left lagaunga in right subtree
          5 (root node)
       /      \
      1           1 
     / \        /    \
    2   3 left  3 r    2 

    so now I hope so kyun hume VICE VERSA call lagani hogi for checking that is tree symmetric or not
 
 */
class Solution {
    public boolean isMirrorImage(TreeNode leftNode,TreeNode rightNode){
        if(leftNode==null && rightNode==null){
            return true;
        }
        if(leftNode==null || rightNode==null){
            //means dono mein se ek null hai and ek nhi hai means they are not equal
            return false;
        }

        return (leftNode.val==rightNode.val) && isMirrorImage(leftNode.left,rightNode.right) && isMirrorImage(leftNode.right,rightNode.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isMirrorImage(root.left,root.right);
    }
}
