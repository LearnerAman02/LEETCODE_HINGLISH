//pblm link --> https://leetcode.com/problems/find-common-characters/description/?envType=daily-question&envId=2024-06-05
class Solution {
    public List<String> commonChars(String[] words) {
        /*
        Approach ye hai ki hum count store karenge initially of each character in first word of given array and than hum 
        remaining strings ko traverse karenge and har ek string ke character ke frequency ko find karenge and minimum value se replace karenge
        example se samajhte hai
        initial count array of length 26 --{because hamare paas 26 LOWERCASE LETTERS hai}
                 a b c d e f g                z
        count = {0,0,0,0,0,0,0,..............,0}
        now taking the first string "bellla"
                 a b c d e f g    l              z
        count = {1,1,0,0,1,0,0,..,3,............,0}

        now taking the second string "label"
                 a b c d e f g    l              z
        temp =  {1,1,0,0,1,0,0,..,2,............,0} -- {temporary array for other words in the string}
        ab hum logically soche toh INTERSECTION of characters honge from string 1 and string 2 - {a,b,e,l,l}
        means hume l ki minimum value se update krna padega count array 
        yahi process krni hai ITERATIVELY simply for all the remaining words in array
        finally we will get non-zero frequency/count characters in count array and wahi hamare intersection of characters honge for all the words in given array
        and at last count array ko traverse kro and characters ke frequency ke basis par unko utne time append krdo
        */
        List<String> ans = new ArrayList<>();
        int count[] = new int[26];
        String w = words[0];
        for(int i=0;i<w.length();i++){
            char ch = w.charAt(i);
            count[ch-'a'] = count[ch-'a']+1;
        }
        //System.out.println(Arrays.toString(count));
        for(int i=1;i<words.length;i++){
            int temp[] = new int[26];
            String s = words[i];
            for(int j=0;j<s.length();j++){
                char ch = s.charAt(j);
                temp[ch-'a'] = temp[ch-'a']+1;
            }
            //now temp and count mei se minimum frequency ki value ko store krdo
            for(int k=0;k<26;k++){
                int min = Math.min(count[k],temp[k]);
                count[k] = min;
            }
        }
        //System.out.println(Arrays.toString(count));
        for(int i=0;i<26;i++){
            if(count[i]>0){
                int t = count[i];
                for(int j=0;j<t;j++){
                    char character = (char)(i+'a');
                    String st = "";
                    st += character;
                    ans.add(st);
                }
            }
        }
        return ans;
    }
}

//T.C. --> O(N*(M+26)) ~ O(N*M) {N-length of array,M-length of string at index i}//for traversing the entire count array
//S.C. --> O(26) ~ O(1) {for creating temporary and count array}
//if we consider the space which we are consuming for storing answer as well than SPACE COMPLEXITY -- O(L) {L is total number of common characters}
