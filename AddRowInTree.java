/*
pblm link --> https://leetcode.com/problems/add-one-row-to-tree/description/?envType=daily-question&envId=2024-04-16


My Logic is ENHANCED VERSION of NORMAL BFS TRAVERSAL
bas har ek level pe jab hum chalenge tab uss case mein ENSURE karo ki main next level number kya hai woh lete hue chalu
 and agar level+1 == depth ho jaata hai 
 than in that case just traverse queue at that level and attach new Node to each node at that level

 Ab kuchh log bolenge,
 Bhaiya  WOH AAP KYA BOL RAHE HO SAMAJH MEIN NHI AA RAHA HAI, WOH KYA NICHE SUBTITLE BHI NHI HAI NAA :):)

JOKES APART 

Ab samajhte hai diagramatically ki main kya kehne ki maine upar jo logic bola hai uska actual meaning kya hai
       1       ---- level - 1
    /     \
   2        3   ---- level - 2
  /  \     /   \
 4     5  6     7 ---- level - 3
above is the given tree and depth at which new nodes are to be inserted is (depth=2)

 so agar main level 1 pe hoon toh main next level kaunsi hai woh check karte hue chalunga
 so initially level = 1 hoga and than hum BFS TRAVERSAL start karenge and next level number track karte hue chalenge

 samajhte hai kaise it will help
 starting iteraton over queue with 
 q = [1]  --- initial queue value for BFS traversal
 level = 1
 now in ITERATION

 level+1 = 2 (means level+1 == depth hai kya?? haanji hai so aapne simply queue se nodes nikalne hai aur newnodes banake attach kar dene hai har ek node se) 
       1       ---- level - 1
    /     \
   2        3   ---- level - 2
  /  \     /   \
 4     5  6     7 ---- level - 3

     
ADJUSTMENT OF Node pointers bhi hume krna padega properly
logic u can see in code
               1       ---- level - 1
          /        \
 temp1-->  2    temp2-->    3   ---- level - 2
       /  \         /   \
      4    5       6     7 ---- level - 3
once newnodes ko attach karke humne ONE ROW ko badha diya than u don't need to apply BFS TRAVERSAL in remaining part of the nodes

else agar level+1 == depth nhi hai toh aage level pe jaate jaao and BFS traversal karte jaao once level+1 == depth hua than upar wala logic apply kardo and loop break kardo
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> que = new LinkedList<>();
        //edge case ko hum tackle kar rahe hai
        if(depth==1){
            //create new Node and make it as root and current tree ko NEW ROOT ka left subtree banado
            TreeNode newNode = new TreeNode(val);
            TreeNode temp = root;
            root = newNode;
            root.left = temp;
            return root;
        }
        //BFS TRAVERSAL karo
        int level = 1;
        que.add(root);
        while(!que.isEmpty()){
            level++;
            //level+1 check karo
            if(level == depth){
                //BFS traversal hi karo just har ek node ke saath newnode ko attach kardo
                int n = que.size();
                for(int i=0;i<n;i++){
                    //sabse front mein jo node hai usko DEQUEUE karao
                    TreeNode node = que.poll();
                    //check karo ki kya curr node ka left left OR RIGHT , jo bhi exist karta hai ENQUEUE karado
                    TreeNode temp1 = node.left;
                    TreeNode temp2 = node.right;
                    if(node.left != null){
                        temp1 = node.left;
                    }
                    if(node.right != null){
                        temp2 = node.right;
                    }
                    //adjusting pointers
                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);
                    node.left.left = temp1;
                    node.right.right = temp2;
                }
                break;
                //and than just loop ke bahar aa jaao
            }
            else{
                //current level pe kitne nodes hai unka count lelo traverse karne ke liye
                int n = que.size();
                for(int i=0;i<n;i++){
                    //sabse front mein jo node hai usko DEQUEUE karao
                    TreeNode node = que.poll();
                    //check karo ki kya curr node ka left left OR RIGHT , jo bhi exist karta hai ENQUEUE karado
                    if(node.left != null){
                        que.offer(node.left);
                    }
                    if(node.right != null){
                        que.offer(node.right);
                    }
                }
            }
        }
        return root;
    }
}
