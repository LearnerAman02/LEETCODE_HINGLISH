/*
Problem link --> https://leetcode.com/problems/maximize-happiness-of-selected-children/description/?envType=daily-question&envId=2024-05-09
Brute Force Approach
T.C. --> O(N logN)
S.C. --> O(N) {Priority Queue ka extra space + SORTING PROCESS as well}
Logic --> hume childrens ko aise pick krna hai such that at the end vakue of HAPPINESS maximum aaye
so hume thoda GREEDY APPROACH lagana padega, means woh childrens jinki happiness sabse jyada hai, unko pehle pick karo and than remaining students ko

[1,2,3]  --> happiness = 0, k=2

picking child with happiness = 3
[1,2]  --> happiness = 3, k=1
so now remaining childrens ka happiness value 1 se kaam ho jaayega W.R.T. OG value
[0,1]  --> happiness = 3, k=1

now pick children with happiness = 1
[0] --> happiness = 4, k=0
and value decrease hogi, for remaining childrens 
[-1]

and since k=0 ho chuka we cannot pick childrens further
so final answer --> happiness = 4

*/
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<happiness.length;i++){
            queue.offer(happiness[i]);
        }
        long maxHappiness = 0;
        for(int i=0;i<k;i++){
            long happy = queue.poll()-i;
            if(happy>0){
                maxHappiness += happy;
            }
            else{
                break;
            }
        }
        return maxHappiness;
    }
}

//Approach 2 --> Array ko sort krdo and than aap values ko pick karte jaao from right end and countOfSelected child bhi maintain karte jaao and finalHappiness value mei add karte jaao happiness ki value ko agar {happiness>0}
Time Complexity --> O(N logN) , Space complexity --> O(1) {constant space w.r.t. variables jo humne use kiye hai, but internally jab SORTING hogi tab QUICK SORT or MERGE SORT mei extra space consumption hoga hi hoga}
so DEEP DIVE krke soche toh S.C. is not constant in this case as well
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long maxHapp = 0;
        int countOfSelected = 0;//selected child ka count store krne ke liye
        for(int i=happiness.length-1;i>=0;i--){
            long happy = happiness[i]-countOfSelected;
            // agar current child ki happiness > 0 and number of selected child abhi k se kam hai toh maxHappy{i.e. maximumHappiness} mei add krdo current child ki KHUSHI ko :))
            if(happy>0 && countOfSelected<k){
            maxHapp += happy;
            countOfSelected++;
            }
            else{
                break;
            }
        }
        return maxHapp;
    }

}
