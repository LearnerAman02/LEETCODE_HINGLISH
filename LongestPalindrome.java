//pblm link --> https://leetcode.com/problems/longest-palindrome/?envType=daily-question&envId=2024-06-04
//T.C. --> O(N) 
//S.C. --> O(N)
class Solution {
    public int longestPalindrome(String s) {
        //Simple logic ye hai ki hume string ko traverse krna hai and store krna hai count of each character occurence
        //and hum ek length variable lenge jisko we will initialize with 0 and than
        //after that hum hashmap ko traverse kr lenge and if count of a character is EVEN than length mei uss EVEN number ko add kr denge
        //because we know "aabbcbbaa" is palindrome agar a and b characters ka count is EVEN and also ODD length palindrome ke liye we need one ODD frequency/count character
        HashMap<Character,Integer> hmap = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            hmap.put(s.charAt(i),hmap.getOrDefault(s.charAt(i),0)+1);
        }
        int even = 0;
        int odd = 0;
        int maxLen = 0;
        for(Character c : hmap.keySet()){
            int count = hmap.get(c);
            if(count>1 && count%2==0){
                maxLen += count;
                even++;
            }
            else if(count>1 && count%2==1){
                int add = count/2;
                add *=2;
                maxLen += add;
                odd++;
            }
            else{
                //count == 1
                odd++;
            }
        }
        if(odd>0){
            maxLen++;//agar koi odd frequency ka exist krta hai than at last increment its count
            //eg --> a-{4}, b-{2} , c-{6}, f-{3}
            //so yaha f ki frequency odd hai so at the end f can be added to make ODD length palindrome
        }
        return maxLen;
    }
}
