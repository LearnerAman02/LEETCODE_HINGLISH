//T.C. --> O(m) {m} --> rows of 2D array
//S.C. --> O(1)
//pblm link --> https://leetcode.com/problems/average-waiting-time/description/
class Solution {
    public double averageWaitingTime(int[][] customers) {
        double ans = 0;
        double total = 0;
        int m = customers.length;
        double finishTime = customers[0][0];//pehle customer jis time pe aaya usko store kara lo means it will be the start time of cooking when the first customer places the order
        for(int i=0;i<m;i++){
            double waitingTime = 0;
            //agar customer previous customer ke finish time ke andar aa gaya hoga than directly banana start krdo after serving the last customer
            //nhi toh bahot time/non overlapping TIME INTERVAL ke baad aaya agar than uska arrival time will become start time of cooking and will serve after the time taken to make the food
            if(customers[i][0]<=finishTime){
                finishTime += customers[i][1];
            }
            else{
                finishTime = customers[i][0];
                finishTime += customers[i][1];
            }
            //actual waiting time hoga jab chef ne bana kr de diya - jis time pe customer aaya tha
            waitingTime = finishTime - customers[i][0];
            total += waitingTime;
        }
        ans = total/m;
        return ans;
    }
}
