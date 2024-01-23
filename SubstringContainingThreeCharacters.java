// problem link - https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
// ek array mein hum store karenge frequency of occurence of a,b,c
// we will take two ptrs - e=0 and s=0
// we will iterate the string using e ptr and uske corresponding frequency ko update karenge and once frequency of all three(a,b,c) is >=1 than hum saare possible substring ke count ko add kar lenge in final ans variable
// to find all possible substring --> string ka length - end ptr position
// now hume window ko shrink karna hoga so that aage ke possible substrings ko we can find out so hum start pte ke character ko check karenge and uske frequency ko decrease karenge and uske baad increase the start pointer
// now we will repeat the same thing till e==string ka length
class Solution {
    public int numberOfSubstrings(String s) {
        int abc[] = new int[3];
        int start=0;
        int substr=0;
        for(int end=0;end<s.length();end++){
            abc[s.charAt(end)-'a']++;// incrementing the frequency corresponding to character
            while(abc[0]>=1 && abc[1]>=1 && abc[2]>=1){
                substr += s.length()-end;
                abc[s.charAt(start)-'a']--;// decrementing the count corresponding to character
                start++;
            }
        }
        return substr;
    }
}
