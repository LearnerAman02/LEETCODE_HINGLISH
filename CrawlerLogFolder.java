Time Complexity --> O(N)
Space Complexity --> O(1)
//link --> https://leetcode.com/problems/crawler-log-folder/?envType=daily-question&envId=2024-07-10
class Solution {
    public int minOperations(String[] logs) {
        int count=0;
        int n = logs.length;
        for(int i=0;i<n;i++){
            if(logs[i].equals("../") && count>0){
                //agar count>0 ,it specifies that ki current main folder ke andar subfolders hai , so if "../" is typed 
                //decrement the count i.e. go back to parent folder of current folder
                count--;
            }
            else if(logs[i].equals("../") && count==0){
                //if count=0 means u are int the main folder, so if u are in the "../" no need to decrement the count
                count=0;
            }
            else if(logs[i].equals("./")){
                continue;
            }
            else{
                count++;
            }
        }
        if(count<=0){
            return 0;
        }
        else{
            return count;
        }
    }
}
