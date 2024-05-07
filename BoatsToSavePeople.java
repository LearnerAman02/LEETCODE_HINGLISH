// pblm link --> https://leetcode.com/problems/boats-to-save-people/?envType=daily-question&envId=2024-05-04

/*
T.C. --> O(N)
S.C. --> O(1)

LOGIC --> Question ye bol raha hai ki AT MAX TWO PEOPLE CAN BE INSIDE the boat
Toh isse ye intuition aata hai ki hume TWO POINTERS use karna 

Ab kuchh log sochenge 2 pointers hi kyun 
kyunki woh 2 pointers weight of 2 different persons ko point karenge and unke sum ke help se hum ye pata kar lenge ki kiske liye hume boat ko use krna hai

Yaha par hum 2 pointers ke saath saath hum GREEDY METHOD bhi use karenge (kyunki hamara motive ye hai ki sabse jyada weight walo ko pehle hi boat mei place kar de)

Now DRY RUN krke hamare approach ko samajhte hai
[3,2,2,1]
First SORT kardo array ko

[1,2,2,3] - limit = 3,boats =0;
 l     r    --> currentLoad = 1+3 = 4 (kyunki currentLoad>limit hai, toh hum basically {ek hi person ko boat mei place kar sakte hai}, so GREEDY APPROACH ka use karte hue {your new WWE World Heavy Weight Champion} oh okk jokes apart jyada weight wale person ko boat mei place kar denge)
 so decrement pointer r

[1,2,2,3] - limit = 3,boats=1
 l   r    --> currentLoad = 1+2 = 3  (now iss case mei currLoadtoh=limit hai, toh hum dono log ko boat pe place kr sakte hai)
so now increment l ptr and decrement r pointer

[1,2,2,3] - limit = 3,boats=2
   r  
   l
now agar same index pe l and r pointer hai,toh abhi woh wala person boat mei ab tak place nhi kiya gaya hai
so now ab usko bhi boat mei place kardo
finally boats = 3(OUR ANSWER)
*/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats=0;
        int l=0;
        int r=people.length-1;
        while(l<r){
            int currLoad = people[l]+people[r];
            if(currLoad>limit){
                boats++;
                r--;
            }
            else if(currLoad==limit){
                boats++;
                l++;
                r--;
            }
            else if(currLoad<limit){
                boats++;
                l++;
                r--;
            }
        }
      //now agar ek last banda remaining hai place krna than usko bhi aap place kardo
        if(l==r && people[l]<=limit){
            boats++;
        }
        return boats;
    }
}
