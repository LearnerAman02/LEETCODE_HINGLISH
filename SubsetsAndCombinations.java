//subsets waale questions bas ye pattern par based hai --> PICK and DON'T PICK + YE ENSURE KARO KI BACTRACKING KE TIME HUME KYA KARNA HAI 
//According to that code likho and all these type of questions will be FILLING GLASS OF WATER FOR U

//Pblm link --> https://leetcode.com/problems/subsets/
class Solution {
    //Time Complexity --> O(2^n) and SPACE COMPLEXITY --> O(n*2^n) {SYSTEM MEMORY SPACE toh O(n) hi hai but AUXILIARY SPACE ka jyada hai O(n*2^n)}
    //global variable declare kar raha hai List of List ko jo store karega
    public List<List<Integer>> result = new ArrayList<>();

    public void generateSubset(int[] arr,int idx,List<Integer> list){
        if(idx==arr.length){
            //ye base case hai means hum iske aage elements ko store nhi kar sakte hai in list
            //and ek possible set of SUBSET generate ho gaya hai just usko store karado
            result.add(new ArrayList(list));
            return;
        }
        //add kardo element ko in list
        list.add(arr[idx]);
        generateSubset(arr,idx+1,list);
        //remove krdo bactrack karte time and so that futher combinations bhi add kar sake
        list.remove(list.size()-1);
        generateSubset(arr,idx+1,list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        generateSubset(nums,0,new ArrayList<>());
        return result;
    }
}

//Pblm link --> https://leetcode.com/problems/combinations/description/
class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    //APPROACH - 2 {Using FOR LOOP} 
    public void generateCombo(int start,int n,int k,List<Integer> list){
        if(k==0){
            res.add(new ArrayList(list));
            return;
        }
        if(start>n){
            return;
        }
        for(int i=start;i<=n;i++){
            list.add(i);//take the element
            generateCombo(i+1,n,k-1,list);
            //bactracking ke time I will goanna remove the element from the list
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        generateCombo(1,n,k,new ArrayList());
        return res;
    }
}

