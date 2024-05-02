//pblm link --> https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/
class Solution {
    public int findMaxK(int[] nums) {
        //approach--> ek hashmap lo and usme saare negative numbers ko store kara do and than phir se array ko traverse karo and maximum positive number find karo agar woh hashmap mein hai toh
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int max = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                hmap.put(nums[i],1);
                }
            }
        //now array ko phir se traverse karo and max ko update karo agar uska negative value hai already than max ko update karo
       for(int i=0;i<nums.length;i++){
           if(nums[i]>0){
               int temp = -1*nums[i];
               if(hmap.containsKey(temp)){
                   max = Math.max(max,nums[i]);
                   }
               }
           }
       return max;
    }
}
