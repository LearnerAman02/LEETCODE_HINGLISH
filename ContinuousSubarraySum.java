//Pblm link --> https://leetcode.com/problems/continuous-subarray-sum/description/?envType=daily-question&envId=2024-06-08
//T.C. --> O(N) 
//Space Complexity: O(min(n, k)) - HashMap worst case mein n elements store karega, par kyunki modulo values 0 se k-1 tak ho sakti hain, zyada se zyada k elements store honge
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //NOTE --> agar sum1%k == n hai and sum2%k == n than iska matlab ye hai ki inn sum ke beech ka jo subarray hai woh MULTIPLE of k hai
        //EXAMPLE SE SAMAJHTE HAI
        /* currsum = 0 ,   map --> {}, k = 6
          [23,2,4,6,7]
          
            i
          [23,2,4,6,7]  , currsum = 23 ,   mod = 23%6 = 5, map --> {5-0}
            0 1 2 3 4

              i
          [23,2,4,6,7]  , currsum = 25 ,   mod = 25%6 = 1, map --> {5-0 ,1-1}
            0 1 2 3 4
          
                i
          [23,2,4,6,7]  , currsum = 29 ,   mod = 29%6 = 5, map --> {5-0 ,1-1 ,5-2}
            0 1 2 3 4
          but ab yaha aap dekho 5 remainder pehle aa chuka tha at index 0 and woh phir se repeat hua hai at index 2
          iska meaning ye hai 0 index ke baad jo subarray aaya till index 2 woh multiple of k hai 
          and it is TRUE hume clearly dikh raha hai ki [2,4] aisa subarray hai jiska sum is multiple of 6

          I hope so ye MATHEMATICAL OBSERVATION jo hum use karenge iss question mei it is clear
        */

        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,-1);//agar kahi pe currSum%k ==0 aa gaya toh means waha tak ke pure array ka sum from start index is multiple of k
        int currSum = 0;
        for(int i=0;i<nums.length;i++){
            currSum += nums[i];
            int mod = currSum%k;
            if(!hmap.containsKey(mod)){
                hmap.put(mod,i);
            }
            else{
                int idx = hmap.get(mod);
                //check kro ki kya length >=2 hai
                if(i-idx > 1){
                    return true;
                }
            }
        }
        return false;
    }
}


//exactly same approach pe question hai ye doosra
//pblm link --> https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
//agar sum = x phir se aage repeat hua toh iska meaning ye hai ki beech ke subarrays ka sum=0 hai 
// ------------- T.C. --> O(N) and S.C. --> O(N)
CODE
  class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,-1);
        int currSum = 0;
        int maxLen = 0;
        for(int i=0;i<arr.length;i++){
            currSum += arr[i];
            if(hmap.containsKey(currSum)){
                int idx = hmap.get(currSum);
                maxLen = Math.max(maxLen,i-idx);
            }
            else{
                hmap.put(currSum,i);
            }
        }
        return maxLen;
    }
}
