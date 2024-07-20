import java.util.*;
public class Main
{
    public static List<Integer> inorder(TreeNode node){
    List<Integer> l = new ArrayList<>();
    if(node==null){
        return l;
    }
    Stack<TreeNode> st = new Stack<>();
    TreeNode current = node;
    while(current!= null || !st.isEmpty()){
        while(current != null){
            st.push(current);
            current = current.left;
        }
        TreeNode temp = st.pop();
        l.add(temp.val);
        current = temp.right;
    }
    return l;
}
	public static void main(String[] args) {
		//creation of BINARY Tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		List<Integer> t = inorder(root);
		System.out.println(t);
	}
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.val = data;
        this.left = null;
        this.right = null;
    }
}
