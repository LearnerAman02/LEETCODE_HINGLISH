//pblm link --> https://leetcode.com/problems/longest-consecutive-sequence/description/
class Solution {
    //my BRUTE FORCE APPROACH 
    // step 1 --> full array ko traverse karna start Karo 
    // step2 - Ek TreeMap use karo jo ki sorted form mein store karega aap ke array ke elements ko as keys
    //now pehla number nikal lo and check karo ki next number tree mein jo hai kya woh consecutive hai and if hai than just perform the iteration and increase the counter
    public int longestConsecutive(int[] nums) {
        int consecutive = 0;
        if(nums.length==0){
            return 0;
            }
        TreeMap<Integer,Integer> tmap = new TreeMap<>();
        //now array ko traverse karo and put in treemap
        for(int i=0;i<nums.length;i++){
            tmap.put(nums[i],1);
            }
        int num = nums[0];
        System.out.println("TreeMap : "+tmap);
        //now treemap ko traverse karo and first element ko extract karo and check for consecutive
        int maxLen = Integer.MIN_VALUE;
        for(Map. Entry<Integer,Integer> entry : tmap.entrySet()){
            //treemap se key ko nikalo and check karo ki kya woh num+1 hai means consecutive h??
            //if yes than update maximum consecutive length
           // else aapne, num ko currNum kar dena hai and consecutive numbers ke length ko 1 kar dena hai means just currposition se consecutive numbers ab start honge
            int currNum = entry.getKey();
            if(currNum == num+1){
                consecutive++;
                num = currNum;
                maxLen = Math.max(consecutive,maxLen);
                }
            else{
                num = currNum;
                consecutive = 1;
                maxLen = Math.max(consecutive,maxLen);
                }
            }
       return maxLen;
    }
}
