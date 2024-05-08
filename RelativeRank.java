//problem link --> https://leetcode.com/problems/relative-ranks/?envType=daily-question&envId=2024-05-08

//Brute Force Approach --> Bahot hi easy hai, Simply TreeMap mei data store karao array ka with index position
//NOTE --> Jab aap data store kara rahe hai toh ye dhyaan rakhe ki woh DESCENDING ORDER OF KEYS ke basis pe place ho
//and than simply treemap ko traverse karo and index pe required values ko store kara do
// T.C. --> O(N logN) , S.C. --> O(N) {Extra Space of TREEMAP}
import java.util.Collections;
class Solution {
    public String[] findRelativeRanks(int[] score) {
        String ans[] = new String[score.length];
        TreeMap<Integer,Integer> tmap = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<score.length;i++){
            tmap.put(score[i],i);
        }
        //now simply treemap ko traverse karo and index pe values ko store kara do
        int rank=1;
        for(Map.Entry<Integer,Integer> entry : tmap.entrySet()){
            if(rank==1){
                int idx = entry.getValue();
                ans[idx] = "Gold Medal";
            }
            else if(rank==2){
                int idx = entry.getValue();
                ans[idx] = "Silver Medal";
            }
            else if(rank==3){
                int idx = entry.getValue();
                ans[idx] = "Bronze Medal";
            }
            else{
                String s = String.valueOf(rank);//to convert a data type into string
                int idx = entry.getValue();
                ans[idx] = s;
            }
            rank++;
        }
        return ans;
    }
}
