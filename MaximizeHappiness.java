/*
Brute Force Approach
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
