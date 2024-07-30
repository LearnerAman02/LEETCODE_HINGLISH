Time Complexity --> O(N) and Space Complexity --> O(number of characters)
//meri thought process ye hai ki mai ek hashmap banaunga aur ek 2 length ka array banaunga
//aur iss array mei hum store karenge frequency of 'a' and 'b' 
//ab mai array ko traverse krna start karunga aur map 'a' ke aur 'b' ke latest occuring index ko store karaunga aur array mei inki frequencies ko bhi inrement kr dunga
//ab jab bhi 'a' ka occurence b ke baad aayega tab mai simply check krunga ki frequency of 'b'>0 hai, agar hai than simply decrement krdo uski frequency ko
//and aap increment krdo frequency of 'a' ko

class Solution {
    public int minimumDeletions(String s) {
        int[] arr = new int[2];
        HashMap<Character,Integer> hmap = new HashMap<>();
        char ch[] = s.toCharArray();
        int moves = 0;
        for(int i=0;i<ch.length;i++){
            //hashmap mei current character ko store krdo with its index
            hmap.put(ch[i],i);
            //ab agar map mei 'b' hai, toh uske last index ko check kro kya uske baad agar 'a' aaya hai aur 
            //'b' ki frequency greater than 0 hai than simply frequency ko ghatado aur moves mei +1 krdo
            if(ch[i]=='a' && hmap.containsKey('b')){
                int idx = hmap.get('b');
                if(idx<i && arr['b'-'a']>0){
                    arr['b'-'a']--;
                    moves++;
                }
            }
            int val = ch[i]-'a';
            arr[val]++;
        }
        return moves;
    }
}
