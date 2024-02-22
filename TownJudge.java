// pblm link --> https://leetcode.com/problems/find-the-town-judge/?envType=daily-question&envId=2024-02-22
// MY APPROACH --> we will have a list jisme hum trust ko iterate karke saare expected judge ko store karenge
// woh saare members jo [1,2] 2nd position pe hai of each row woh hamare expected judges hai
// than hum phirse iterate karenge trust 2D array ko and check karenge ki kahi hamara expected judge kisi aur pe trust toh nhi karta
// and agar nhi karta toh hum uss expected judge ke through full array ko traverse kar lenge and it will become our FINAL JUDGE
// And atlast hume ye check karna hai ki all remaining members should trust our final judge
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0){
            if(n==1){
                return n;
            }
            else{
                return -1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        int row = trust.length;
        for(int i=0;i<row;i++){
            int expJudge = trust[i][1];
            if(!list.contains(expJudge)){
                list.add(expJudge);
            }
        }
        int finalJudge = -1;
        // now hum list ke har ek element ko traverse karenge and check with the first person in the matrix agar first pe hai than break
        // else agar nhi hai than maintain a count variable and if cnt became equal to row length means it is independent of every other
        for(int i=0;i<list.size();i++){
            int exp = list.get(i);
            int cnt =0;
            for(int j=0;j<row;j++){
                int nonJudge = trust[j][0];
                if(nonJudge == exp){
                    break;
                }
                else{
                    cnt++;// agar yaha par hi count equal to length ho gaya than break kardo because nhi toh next expected judge ke liye loop phir se chalega and u will not able to get the real judge
                }
            }
            if(cnt==row){
                finalJudge = list.get(i);
                break;
            }
        }
        // agar expected judge hai hamare list mein than it should form pair with every remaining number(person)
        // and uske liye just check each member who has done pairing with our finalJudge and keep subtracting from sum of N term value at the end Jude hi bachega
        int sum = n*(n+1)/2;
        for(int i=0;i<row;i++){
            int pairedWithJudge = trust[i][0];
            if(trust[i][1]==finalJudge){
                sum -= pairedWithJudge;
            }
        }
        if(sum == finalJudge){
            return finalJudge;
        }
        else{
            return -1;
        }
        //return -1;
    }
}
