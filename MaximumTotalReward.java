class Solution {
    //ye hai meri recursive approach but ye rha hai TLE, because there are OVERLAPPING SUBPROBLEMS
    public int maxReward = 0;
    public int calculateReward(int[] a,int x,int[] visit){
        for(int i=0;i<a.length;i++){
            if(a[i]>x && visit[i]==0){
                //mark it visited
                visit[i] = 1;
                x+=a[i];
                maxReward = Math.max(x,calculateReward(a,x,visit));
                visit[i] = 0;
                x-=a[i];
            }
        }
        return maxReward;
    }
    public int maxTotalReward(int[] rewardValues) {
        int visit[] = new int[rewardValues.length];
        int ans = calculateReward(rewardValues,0,visit);
        return ans;
    }
}

//OPTIMAL USING DP
class Solution {
    // because there are OVERLAPPING SUBPROBLEMS
    // toh janaab isiliye hum use karenge DP ka 
    // and mai use kar raha hai TOP DOWN DP i.e. {RECURSION + MEMOIZATION}
    public int maxReward = 0;
    public int calculateReward(int[] a,int x,int[] visit,int[] dp){
        //agar dp array mei answer exist krta hai than return kr jaao
            if(dp[x]!=-1){
                return dp[x];
            }
        for(int i=0;i<a.length;i++){
            if(a[i]>x && visit[i]==0){
                //mark it visited
                visit[i] = 1;
                x+=a[i];
                maxReward = Math.max(x,maxReward);
                int tempAns = calculateReward(a,x,visit,dp);
                visit[i] = 0;
                x-=a[i];
            }
        }
        //store current answer in dp array
        dp[x] = maxReward;
        return maxReward;
    }
    public int maxTotalReward(int[] rewardValues) {
        int visit[] = new int[rewardValues.length];
        //creating a DP array
        int[] dp = new int[4000];
        //now aapka question hoga ki DP array ka size 4000 hi kyun liya 
        //dekho contraint mei max value of array 2000 diya hai
        //toh jo maximum reward banega it will be {1999 + 2000 = 3999} 
        // so isiliye dp array ka size 4000 liya hai so that saare possible maximum rewards ki value store kar sake
        for(int i=0;i<4000;i++){
            dp[i] = -1;
        }
        int ans = calculateReward(rewardValues,0,visit,dp);
        return ans;
    }
}
