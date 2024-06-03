//pblm link --> https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
class Solution {
    //simply logic ye hai ki hume contiguous aane wale subarrays ka count store krna hai 
    //and we know the formula that for n length --> we have n*(n+1)/2 SUBARRAYS 
    //so count ki value nikalne ke baad we will add the total sum of subarrays with zero using the above formula only 
    public long zeroFilledSubarray(int[] nums) {
        long sum = 0;
        long count = 0;
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==0 && nums[i+1]==0){
                count++;
            }
            else{
                if(nums[i]==0){
                    count++;//if current index is also 0 than increment the count
                    sum += (count*(count+1))/2;//finally add the total numbers of possible subarrays 
                }
                count = 0;
            }
        }
        if(nums[n-1]==0){
            count++;//agar last idx of the array pe we have 0 than hume woh bhi consider krna hai
        }
        sum += (count*(count+1))/2;
        return sum;
    }
}
