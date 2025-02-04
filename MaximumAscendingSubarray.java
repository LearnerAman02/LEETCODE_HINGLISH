Problem link --> https://leetcode.com/problems/maximum-ascending-subarray-sum/description/?envType=daily-question&envId=2025-02-04
  
class Solution {
    public int maxAscendingSum(int[] nums) {
        //now trying to optimize it using SLIDING WINDOW APPROACH
        //  s  e
        // [10,20,30,5,10,50]
        int curr = nums[0];//curr = 10
        int sum = nums[0];//sum = 10
        int s=0;
        int e=1;
        int max = nums[0];
        //agar array ka length = 1 hai toh simply return krdo sum ko
        if(nums.length == 1){
            return sum;
        }
        else{
            //end pointer ko increment karte jaao jab tak current variable se greater value mil rahi hai
            //  s  e
            // [10,20,30,5,10,50]
            while(e<nums.length){
                if(nums[e]>curr){
                    //add krdo sum ke andar end pointer pe jo value hai
                    //  s  e
                    // [10,20,30,5,10,50]
                    sum += nums[e];// sum = 30
                    curr = nums[e];//current variable ko update krdo curr = 20
                    max = Math.max(sum,max);//max ko update krdo beause hume ek possible INCREASING SUBARRAY mila hai  max = Math.max(10,30)
                }
                else{
                    //agar curr ki value se smaller value mili hai nums[e] pr toh hume iska matlab ye hai ki ab hume DECREASING subarray mil rha hai
                    //toh isse pehle jo ASCENDING SUBARRAY tha uska maximum sum hume mil gaya hai and hume an new ASCENDING subarray find krna hai jiska starting element nums[e] hoga
                    //isiliye update curr = nums[e]
                    //  s        e
                    // [10,20,30,5,10,50]
                    curr = nums[e];//curr = 5
                    while(s<e){
                        //sum ke andar abhi previous ASCENDING order subarray ka sum stored hai toh sb start (s) variable ka use krke sum ko decrease kro
                        //  s        e
                        // [10,20,30,5,10,50]
                        sum -= nums[s]; //sum -= 10 and than sum -= 20 and so on..... till s<e
                        s++;
                    }
                    //ab sum mei new current ki value ko add krdo
                    // sum += 5
                    sum += curr;
                }
                e++;
            }
        }
        return Math.max(sum,max);
    }
}

//Time Complexity --> O(N)
//Space Complexity --> O(1)
