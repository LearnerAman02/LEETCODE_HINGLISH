// pblm link --> https://leetcode.com/problems/longest-repeating-character-replacement/
// logic --> 
// ek array banayenge of size - 26 because iss case we are considering 26 UPPERCASE LETTERS
// now hum ek start ptr lenge and end ptr lenge 
// s=0,e=0 and to store ki ek window mein maximum time kaunsa element occur hua hai uska track rakhne ke liye we will have maxCount variable and for maximum length we will have maxLen variable
//  e
// "AABABBA"  maxCount = 1 maxLen = 1
//  s
//   e
// "AABABBA"  maxCount = 2(A)  array - [2,0]  maxLen=2
//  s
//    e
// "AABABBA"  maxCount = 2(A)  array - [2,1]  maxLen = 3
//  s
//     e
// "AABABBA"  maxCount = 2(A)  array - [3,1]  maxLen = 4
//  s
//      e
// "AABABBA"  maxCount = 2(A)  array - [3,2]  maxLen = 4 because length-maxCount > k ho gaya hai so iska matlab hai ki maximum A's aaye hai but usme different characters jo aaye hai that value has exceeded by k so it will be invalid string, so ab hume start ko aage badhana padega to decrease window size jab tak k different characters nhi rehte hai usme
//  s
//      e
// "AABABBA"  maxCount = 2(A)  array - [2,2]  maxLen = 4 because length-maxCount > k move s
//   s
//      e
// "AABABBA"  maxCount = 2(A)  array - [1,2]  maxLen = 4
//    s
//       e
// "AABABBA"  maxCount = 2(A)  array - [1,3]  maxLen = 4 
//    s
//        e
// "AABABBA"  maxCount = 2(A)  array - [2,3]  maxLen = 4 because length-maxCount > k  move s
//    s
//        e
// "AABABBA"  maxCount = 2(A)  array - [2,2]  maxLen = 4 because length-maxCount > k  move s
//     s
//        e
// "AABABBA"  maxCount = 2(A)  array - [1,2]  maxLen = 4 
//      s
// stop
class Solution {
    public int characterReplacement(String s, int k) {
        int count[] = new int[26];
        int start=0,maxLen=0,maxCount=0;
        for(int e=0;e<s.length();e++){
            // storing the maxcount of a character that has highest frequency and also storing frequency of current character
            maxCount = Math.max(maxCount,++count[s.charAt(e)-'A']);
            
            // agar window ke andar k se jyada different characters hai toh subtract the frequency of character at start idx and move start
            while(e-start+1-maxCount > k){
                count[s.charAt(start)-'A']--;
                start++;
            }

            maxLen = Math.max(maxLen,e-start+1);
        }
        return maxLen;
    }
}
