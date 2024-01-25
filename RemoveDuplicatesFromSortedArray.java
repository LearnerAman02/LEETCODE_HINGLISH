// problem link --> https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//It is actually a problem for placing non duplicate elements at the start of the array
// Optimal Approach --> keep a ptr i=0,j=1 and count=0 
// iterate the array with the help of j ptr and check karo ki kya nums[i]!=nums[j] than just increment karo i index ko and store nums[j] over there and also increment counter
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        int count=0;// to store the count of not duplicate elements
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                i++;
                count++;
                nums[i]=nums[j];
            }
            j++;
        }
        return count+1;// because count 0 se start hua tha
    }
}
