// pblm link --> https://leetcode.com/problems/word-break/
// Approach --> ek start ptr lenge and doosra end ptr and hum substring produce karenge and than we will make recursive call
// wordbreak(start,end+1,wd) --> jab tak woh string nhi milta jo list (wd) ke andar present hai
// if (substring is in wd List) than initialize start with end value only kyunki uske aage ke substrings ko we have to check
// wordbreak(end+1,end+1,wd)
class Solution {
    public boolean solveWordBreak(int start,int end,String s,HashSet<String> wd,int dp[][]){
        if(dp[start][end]!=-1) return dp[start][end]==1 ? true : false;
        // agar end last character of the string ko pint krta hai toh just check final end mein generated substring is in set or not
        if(end==s.length()-1){
            if(wd.contains(s.substring(start,end+1))) return true;
            return false;
        }

        // now making recursive call if current substring is in set wd
        if(wd.contains(s.substring(start,end+1))){
            if(solveWordBreak(end+1,end+1,s,wd,dp)){
                dp[start][end] =1;// kyunki woh substring exist krta hai in HashSet , store 1
                return true;
            }
        }

        // recursive call for all type of case --> like agar set mein present nhi hai toh bhi
        dp[start][end]=solveWordBreak(start,end+1,s,wd,dp) ? 1:0;// kyunki woh substring exist krta hai in HashSet , store 1, else store 0
        return dp[start][end]==1 ? true : false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        // TLE de dega because of OVERLAPPING SUB PROBLEMS isiliye need to use DP
        int [][] dp = new int[s.length()][s.length()];
        // initializing values with -1
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                dp[i][j] = -1;
            }
        }
        return solveWordBreak(0,0,s,new HashSet<>(wordDict),dp);
    }
}

// kyunki start and end do parameters change ho rahe hai isiliye we will use 2D DP 
// -1 indicates --> answer nhi hai 
// 1 indicates  TRUE , 0 indicates FALSE
