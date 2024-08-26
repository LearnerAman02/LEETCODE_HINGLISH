//ITERATIVE INORDER TRAVERSAL using 2 stacks 
// 1 --> FOR NODE,  2 --> FOR VISITED Flag value
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //iterative approach
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<Integer> s2 = new Stack();
        s1.push(root);
        s2.push(0);//means first time hi visit kiye hai abhi tak
        while(!s1.isEmpty()){
            TreeNode curr = s1.pop();
            int flag = s2.pop();
            if(flag==0){
                if(curr.right != null){
                    //right node ko push krdo and uske corresponding 0 bhi
                    s1.push(curr.right);
                    s2.push(0);
                }
                s1.push(curr);
                s2.push(1);
                if(curr.left != null){
                    //left node ko push krdo and uske corresponding 0 bhi
                    s1.push(curr.left);
                    s2.push(0);
                }                
            }
            else{
                ans.add(curr.val);
            }
        }
        return ans;
    }
}


//ITERATIVE PREORDER TRAVERSAL using 1 stack
class Solution {
    //Now we are using ITERATIVE approach
    //Logic --> pehle root node ko stack mein push karado
    //Jab tak stack empty nhi hai tab tak ye cheez karo -- pop kardo top most element ko and usko list mein add kardo
    // and than uske right node ko push kari and than left node ko push karo
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root!=null){
            st.push(root);
        }
        else{
            return list;
        }
        while(!st.isEmpty()){
            //pop karado node ko
            TreeNode node = st.pop();
            
            //list mein add kar do
            list.add(node.val);
            if(node!=null && node.right != null){
                st.push(node.right);
            }
            if(node!=null && node.left!=null){
                st.push(node.left);
            }
        }
        return list;
    }
}


//ITERATIVE POSTORDER TRAVERSAL using 1 stack
class Solution {
    public void traverse(TreeNode n,List<Integer> list){
        if(n==null){
            return;
        }
        traverse(n.left,list);
        traverse(n.right,list);
        list.add(n.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root,list);
        return list;
    }
}
