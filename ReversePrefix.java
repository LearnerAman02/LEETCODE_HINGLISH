/**
pblm link --> https://leetcode.com/problems/reverse-prefix-of-word/description/?envType=daily-question&envId=2024-05-01
SCROLL BELOW TO SEE MORE BETTER SOLUTION

 My BRUTE FORCE Approach -->
Time Complexity --> O(N) + SPACE COMPLEXITY --> O(N)
 Pehle String ko traverse krna start karenge and than index ko find karenge jo given character ch ka hai
 NOTE --> HUME FIRST INDEX POSITION FIND KARNI HAI
 and than waha tak ka substring le lenge and REVERSE kara denge usko and than just append kara denge to get the desired answer

 Apne logic ko DRY RUN KARKE samjhata hoon ki main kya keh raha hoon actual mein
           0 1 2 3 4 5 6 
 string - "a b c d e f d"  ch = d
 so first occurence of 'd' find karenge and woh yaha pe 3 hai
 so we will take substring from index [0,3] both inclusive 
 so prefixString = abcd
 and remaining string = efd

 now reverse kar denge prefix string ko and than remaining string ke front mein append kara denge
 reversed prefixString = dcba
 final string = dcbaefd
*/

class Solution {
    public String reversePrefix(String word, char ch) {
        //finding first occurence of char ch
        int index =0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)==ch){
                index=i;
                break;
            }
        }
        //store prefix substring till index i
        String prefix = word.substring(0,index+1);
        word = word.substring(index+1);
        String reversedPrefix = "";
        for(int i=0;i<prefix.length();i++){
            reversedPrefix += prefix.charAt(prefix.length()-i-1);
        }
        word = reversedPrefix + word;
        return word;
    }
}

LITTLE OPTIMAL APPROACH USING TWO POINTERS

           0 1 2 3 4 5 6 
 string - "a b c d e f d"  ch = d
idx = 3 (Wow index mil gaya) and also hamare pass inbuilt function hai {YourStringVariable.indexOf(character)} to find the index

           0 1 2 3 4 5 6 
 array  - [a b c d e f d]  ch = d
           l     r   
now l and r pointers ke help se swap karke reverse karado

class Solution {
    public String reversePrefix(String word, char ch) {
        //index find kar lo using inbuilt function indexOf and than two pointers ka use karke reverse kardo 
        int l = 0;
        int r = word.indexOf(ch);
        char chArr[] = word.toCharArray();
        while(l<r){
            char temp = chArr[l];
            chArr[l] = chArr[r];
            chArr[r] = temp;
            l++;
            r--;
        }

        return new String(chArr);
    }
}
