/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    //Logic ---> 
//          1    --- Level 0
//       /     \
//      2        3    ---- Level 1
//   /     \    /    \
//   4     5   6      7   --- Level 2
//   \ 
//    8                  --- level 3
// so humne level number likh liya hai for each level in the tree , so now if we want LEFT VIEW of a tree 
// than humne uss case mein PREORDER traversal krna hoga 
/*
But now kuchh log sochenge ki WHY PREORDER TRAVERSAL only
because PREORDER traversal mein hum sabse pehle target krte hai Left nodes ko har ek level pe
and for LEFT VIEW of a tree hume har ek level pe sabse LEFTMOST node hi chahaiye

So now itna hume clear h hai ki 
har ek level pe sabse leftmost node chahiye OR left side se sabse first node at each
//          1    --- Level 0
//       /     \
//      2        3    ---- Level 1
//   /     \    /    \
//   4     5   6      7   --- Level 2
//   \ 
//    8                  --- level 3
left View --> [1,2,4,8]

Now question arises ki how we can achieve it??
So basically hum preorder traversal karenge and har ek level pe jaake list mein node ke data ko enter karayenge and 
we will enter the node ka data in list jab list ke andar uss index pe koi node ka data naa ho

//    ptr   1    --- Level 0      initial list size=0, level=0 , (so since level==size of list, list mein ptr jiss node ko point kar raha hai uske data ko put krdo) so list = [1]
//       /     \
 ptr   2        3    ---- Level 1  initial list size=1, level=1 , (so since level==size of list, list mein ptr jiss node ko point kar raha hai uske data ko put krdo) so list = [1,2]
//   /     \    /    \
ptr  4     5   6      7   --- Level 2  initial list size=2, level=2 , (so since level==size of list, list mein ptr jiss node ko point kar raha hai uske data ko put krdo) so list = [1,2,4]
//    \ 
ptr    8                  --- level 3  initial list size=3, level=3 , (so since level==size of list, list mein ptr jiss node ko point kar raha hai uske data ko put krdo) so list = [1,2,4,8]


so basically
we will enter the node ka data in list jab list ke andar uss index pe koi node ka data naa ho
ye upar wale logic ko size==level waale logic se we have implemented jo ki actually mein becomes easy to implement

SO CONCLUSION OF LOGIC -->
Left View of a tree ke liye hume PREORDER TRAVERSAL krna hota hai aur har ek level pe ye check krna ota hai ki agar list ka size == level hai than node ke data ko add karado in list

SO RIGHT VIEW OF TREE ka logic bhi same hoga -->
just PREORDER TRAVERSAL ki jagah humne POSTORDER traversal krna hoga

And Congratulations Aapke 2 questions solve ho gaye hai
*/
//Now writing the code
//Function to return list containing elements of left view of binary tree.
public static void leftViewedNodes(Node node,ArrayList<Integer> list,int level){
    //base case hai ye hamari
    if(node==null){
        return;
    }
    //now agar list ka size == level hai than simply just add krdo node ke data ko
    if(level==list.size()){
        list.add(node.data);
    }
    //make PREORDER Traversal RECURSIVE CALLS
    leftViewedNodes(node.left,list,level+1);
    leftViewedNodes(node.right,list,level+1);
}
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> ans = new ArrayList<>();
      if(root == null){
          return ans;
      }
      leftViewedNodes(root,ans,0);
      return ans;
    }
}

//pblm link -->https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
//right view pblm link --> https://leetcode.com/problems/binary-tree-right-side-view/description/
