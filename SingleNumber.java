// problem link --> https://leetcode.com/problems/single-number/
// BRUTE FORCE --> using hashmap , usme u can store frequency of each element and than by traversing the hashmap u can get non duplicate element
// Most optimal approach hai --> using BIT MANIPULATION
// array ke har ek element ko lenge and uska collective XOR perform karenge with 0
// [4,  1,  2,  1,  2]
// [100,001,010,001,010]
// 000^100 --> 100
// 100^001 --> 101
// 101^010 --> 111
// 111^001 --> 110
// 110^010 --> 100 [4] and this is our non duplicate element
class Solution {
    public int singleNumber(int[] nums) {
        int xor =0;
        for(int i=0;i<nums.length;i++){
            xor = xor^nums[i];
        }
        return xor;
    }
}
