//T.C. --> O(N)
//S.C. --> O(1)
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            //check krlo bhai ki kya current index pe jo value hai and next index ki value, dono odd hai??
            if(arr[i]%2==1 && arr[i+1]%2==1){
                count++;
            }
            else if(count==2 && arr[i]%2==1){
                //if count == 2 means do consecutive odd aa chuke hai, ab current index pe check karna hai ki kya ODD value hai because ye necessary nhi hai ki pair banega
                return true;
            }
            else{
                //if count > = 3 hai return krdo true nhi toh just update count to zero
                if(count>=3){
                    return true;
                }
                else{
                    count = 0;
                }
            }
        }
        //edge case ko tackle kro ki agar count = 2 hai and last index pe value is ODD 
        if((count>=2 && arr[n-1]%2==1)){
            return true;
        }
        return false;
    }
}

//pblm link --> https://leetcode.com/problems/three-consecutive-odds/description/?envType=daily-question&envId=2024-07-01
