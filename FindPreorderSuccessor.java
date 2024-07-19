DRY RUN and try to visualize parallely while aap explaination ko read kr rahe ho
class Solution {
    public static void findPre(Node[] ans,Node n,int key){
        if(n==null){
            return;
        }
        if(n.data<key){
            //ek possible predecessor mil chuka hai ab agar isse bada chahiye
            //jo aur closer hoga to the given key so uske liye search in RIGHT SUBTREE
            ans[0] = n;
            findPre(ans,n.right,key);
        }
        else{
            //if NODE.DATA >= key hai than hume uss case mei
            //predecessor ke liye left subtree mei jaana hoga isiliye update n to n.left
            findPre(ans,n.left,key);
        }
    }
    public static void findSuc(Node[] ans,Node n,int key){
        if(n==null){
            return;
        }
        if(n.data>key){
            //ek possible successor mil chuka hai ab agar isse chhota chahiye
            //jo aur closer hoga to the given key so uske liye search in LEFT SUBTREE 
            ans[0] = n;
            findSuc(ans,n.left,key);
        }
        else{
            //agar current node ki value is LESS THAN OR EQUAL to key hai than hume 
            //SUCCESSOR ke liye RIGHT SUBTREE mei traverse krna hoga isiliye update n to n.right
            findSuc(ans,n.right,key);
        }
    }
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        findPre(pre,root,key);
        findSuc(suc,root,key);
    }
}


Time Complexity --> O(logN)
SC --> O(1)
Similar pattern pe ye 4 o questions hai

https://www.geeksforgeeks.org/problems/inorder-successor-in-bst/1
https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
https://www.geeksforgeeks.org/problems/floor-in-bst/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-bst
