class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //basically traversal of boundary will occur in 3 parts 
    // part 1 --> left boundary nodes
    // part 2 --> leaf nodes traversal from left to right
    // part 3 --> right boundary traversal in REVERSE ORDER
    // NOTE --> This pblm is enhanced version of DFS TRAVERSAL in Tree

    //part - 1
    //left boundary ke liye PREORDER TRAVERSAL except leaf node
    //and left ke depth mein tab tak jaate jaao jab tak node.left!=null
    //else hume right mein traverse karna padega if left node doesn't exist for current node

    // part - 2
    //left to right store LEAF NODES --> ANY TRAVERSAL

    //part - 3
    //right boundary ko reverse mein print karane le liye --> Postorder traversal
    //and right ke depth mein tab tak jaate jaao jab tak node.right!=null
    //else go to left part if right node is null

    public static void traverseLeft(TreeNode node,List<Integer> list){
        //base case 
        //agar ROOT NODE --> NULL hai than return or leaf node pe ho toh bhi return kar jaao
        if(node == null || (node.left==null && node.right==null)){
            return;
        }
        //list ke andar put kar do and than make recursive call in left and than right
        list.add(node.data);
        if(node.left !=null){
            traverseLeft(node.left, list);
        }
        else{
            traverseLeft(node.right, list);
        }
    }
    public static void traverseLeaf(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        //put in the list only when it is LEAF NODE
        if(node.left==null && node.right==null){
            list.add(node.data);
        }
        traverseLeaf(node.left, list);
        traverseLeaf(node.right, list);
    }

    public static void traverseRight(TreeNode node,List<Integer> list){
        //postorder traversal hi hai just backtracking ke time list mein add karenge node ke data ko
        if(node==null || (node.left==null && node.right==null)){
            return;
        }
        //keep on going in right depth of tree if it exists else go in left depth
        if(node.right!=null){
             traverseRight(node.right, list);
        }
        else{
            traverseRight(node.left, list);
        }
        //backtracking ke time store kara hai hai hum data ko in list because we want in REVERSE ORDER
        list.add(node.data);
    }
    public static List<Integer> traverseBoundary(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root==null) return list;
        list.add(root.data);
        traverseLeft(root.left, list);
        traverseLeaf(root, list);
        traverseRight(root.right, list);
        return list;
    }
}
