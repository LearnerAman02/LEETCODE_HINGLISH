// pblm link --> https://leetcode.com/problems/max-consecutive-ones-iii/description/
// Logic -->
// dekhiye , kyunki humse puchha gaya hai ki hume aisa subarray find karna hai ki jisme maximum number number of 1's ho and in that we can flip k numbers of 0's
// in below example k=2
// eg. [1,1,1,0,0,0,1,1,1,1,0]
//     |-----| ---> itne subarray mein 3 ones hai
//eg. [1,1,1,0,0,0,1,1,1,1,0]
//    |-------|  ---> now size increase kari ek se and since k 0's can be flipped this subarray is valid 
//eg. [1,1,1,0,0,0,1,1,1,1,0]
//    |---------| --> again humne ek se increase kiya size ko and ye bhi valid subarray hai kyunki it contains 2 zeroes
//eg. [1,1,1,0,0,0,1,1,1,1,0]
//    |-----------| --> again humne ek se increase kiya size of subarray but ye valid nhi hai because 3 o's hai isme
// toh ab hume size ko decrease karna padega jab tak we dont have atmost 2 zeroes in our subarray
//eg. [1,1,1,0,0,0,1,1,1,1,0]
//      |---------|
//eg. [1,1,1,0,0,0,1,1,1,1,0]
//         |------|
//eg. [1,1,1,0,0,0,1,1,1,1,0]
//           |----|
// toh basically aap ab ye visualize kar paa rahe honge ki ye ek window ko slide karne ki tarah ek subarray create kar paa rahe hai jaha start mein hum size ko increase kar rahe the window ke and later on decrease kar rahe the
// So therefore hum yaha pe sliding window algo use karenge
// Now logic jo hum use karenge yaha par
// PLEASE VISUALIZE PARALLELY BY READING THE LOGIC 
// we will have two pointers i=0,j=0 
// and we will also have ans =0(which stores maximum valid subarray length) and countZero=0 (which stores count of zeroes in a subarray{window})
// hum ek loop chalayenge till j<array.length
// and agar j 0 ko point krta hai toh hum subarray/window mein usko include kar denge and ans = Math.max(j-i+1,ans) (to store maximum length till now)
// uske baad jaise hi j will point to element 0 toh uss case mein hum countZero variable ko increase karenge and check karenge ki count of zeroes in window agar <=k toh woh valid window size hai and woh agar maximum length ki window hai toh hum usko update kara dengeans= Math.max(j-i+1,ans)
// agar countZero became > k iska matlab hume window size ko decrease karna hoga and ab hum i ko incremenet karte jaayenge jab i 1 ko point karega toh hum i ko increment karte jaayenge because uss window mein abhi bhi countZero>k hai, i zero ko point karega toh hum countzero ko decrease karte jaayenge till window contains countZero <=k
class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0;
        int j=0;
        int ans =0;
        int n = nums.length;
        int countZero = 0;
        // handling edge case jisme k is zero
        int maxOne=0;
        int maxi=0;
        if(k==0){
            for(int c=0;c<nums.length;c++){
                if(nums[c]==1){
                    maxOne++;
                }else{
                    if(maxOne>maxi){
                        maxi=maxOne;
                    }
                    maxOne=0;
                }
            }
            if(maxOne>maxi){
                maxi=maxOne;
            }
            return maxi;
        }
        // other cases
        while(j<n){
            if(nums[j]==1){
                ans = Math.max(ans,j-i+1);
                j++;
            }else{
                countZero++;
                if(countZero<=k){
                    ans = Math.max(ans,j-i+1);
                    j++;
                }else{
                    while(i<j && countZero>k){
                        if(nums[i]==0) countZero--;
                        i++;
                    }
                    j++;
                }
            }
        }
        return ans;
    }
}
