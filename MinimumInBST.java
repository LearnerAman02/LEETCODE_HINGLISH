//pblm link --> https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1
/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
LOGIC --> currNode ke left mei jaao and right mei jaao and BACKTRACKING ke time minimum value ko pass karo upar waale level pe
DRY RUN krke samajhte hai logic ko
pehle niche scroll karke CODE dekhlo and than DRY run karo isi example ko

           5(root)
         /    \
        4      6
       /        \
      3          7
     /
    1
if(root==null) simply return krdo -1 {according to question}
nhi toh make call for exploring left subtree agar ROOT.LEFT null nhi 
else explore RIGHT SUBTREE 

kyunki ye BST hai, toh hume pehle check karna hai ki LEFT SUBTREE exist karta hai kya, if not than only we have to explore RIGHT SUBTREE

Hum tree traversal ke RECURSION ka use karenge and har ek node se backtrack karte time, upar waale level pe minimum value ko pass kar denge

           5(root)  since (root.left!=null) make recursive calls for left subtree
         /    \
        4      6
       /        \
      3          7
     /
    1

min = Integer.MAX_VALUE
           5(root)  since (root.left!=null) make recursive calls for left subtree
         /    \
    ptr 4      6
       /        \
      3          7
     /
    1
    
            5(root)  since (root.left!=null) make recursive calls for left subtree
         /    \
        4      6
       /        \
  ptr 3          7
     /
    1

            5(root)  since (root.left!=null) make recursive calls for left subtree
          /    \
         4      6
        /        \
       3          7
      /
ptr   1

             5(root)  since (root.left!=null) make recursive calls for left subtree
           /    \
          4      6
         /        \
        3          7
       /
      1
     /
ptr NULL {base case}
now backtrack karo and upar wale level pe minimum value pass karo
so null node pass karega Integer.MAX_VALUE upar waale node ko


             5(root)  since (root.left!=null) make recursive calls for left subtree
           /    \
          4      6
         /        \
        3          7
       /
      1 minOf(1,Integer.MAX_VALUE)=1
     /
ptr NULL 

             5(root)  since (root.left!=null) make recursive calls for left subtree
           /       \
          4         6
         /            \
        3 minOf(1,3)   7
       /
      1 
     /
ptr NULL 

               5(root)  since (root.left!=null) make recursive calls for left subtree
             /       \
 minOf(4,1) 4         6
           /            \
          3              7
         / 
        1 
       /
     ptr NULL 
     
Node 4 hi last node hai jaha se left subtree ko calls lagi thi, toh woh return kar dega {1} as final minimum value from the function
*/
class Solution {
    public int min= Integer.MAX_VALUE;
    int findMin(Node node){
        if(node==null){
            return min;
        }
        int num1 = findMin(node.left);
        int num2 = findMin(node.right);
        min = Math.min(node.data,min);
        return min;
    }
    int minValue(Node root) {
        if(root==null){
            return -1;
        }
        int minValue=0;
        if(root.left!=null){
            minValue = findMin(root.left);
        }
        else{
            minValue = findMin(root);
        }
        return minValue;
    }
}
