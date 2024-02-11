// Problem link --> https://leetcode.com/problems/palindromic-substrings/description/
// BRUTE FORCE APPROACH -->
// Saare possible substrings generate karo and check karo ki is it PALINDROME or NOT A PALINDROME
// Now how to generate all possible substring 
// 2 loop chalaiye 
// eg --> "aabcde"
//         i  ----> i ke help se we will extract the first character and 
//         j  ----> j ke help se we will iterate over the entire string and generate the possible substring from the character at index i
// and to get the current substring it will be s.substring(i,j+1)
// eg --> "aabcde"
//         i  
//         j  -- substring - "a"
// eg --> "aabcde"
//         i  
//          j  -- substring - "aa"
// eg --> "aabcde"
//         i  
//           j  -- substring - "aab"
// eg --> "aabcde"
//         i  
//            j  -- substring - "aabc"
// eg --> "aabcde"
//         i  
//             j  -- substring - "aabcd"
// eg --> "aabcde"
//         i  
//              j  -- substring - "aabcde"
// eg --> "aabcde"
//         i  
//                j  -- loop breaks for j and now i ke liye it will get incremented by 1
// eg --> "aabcde"
//          i  
//          j ...... repeat the same thing
class Solution {
    public boolean isPalindrome(String str){
        int n = str.length();
        char ch[] = str.toCharArray();
        for(int i=0;i<=n/2;i++){
            if(ch[i]!=ch[n-i-1]){
                return false;
            }
        }
        return true;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int total = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String str = s.substring(i,j+1);
                if(isPalindrome(str)){
                    total++;
                }
            }
        }
        return total;
    }
}
