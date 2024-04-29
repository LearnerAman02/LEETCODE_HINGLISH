//pblm link --> https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/?envType=daily-question&envId=2024-04-29
/**
First samajhte hai ki hume karna kya hai
nums = [2,1,3,4]
now har ek ko XOR kardo ek doosre ke saath and final XOR nikalo, after that aapne ye ensure krna hai ki kya finalXOR == k hai yaa nhi
if it is not than aapne each number ke bit ko flip karna hai and check karna hai ki kab woh k ke equal hoga

BUT don't u think ki ye bahot hi lengthy and complcated task hai ki aap har ek number ke har ek bit ko flip karo and har baar recheck karo ki kya woh k ke equal h??

So hum kuchh result ko NOTICE karte hai and CONCLUSION nikalte hai

num1 in array is 2
num2 in array is 1

PERFORM XOR of num1 and num2
2 --> 010
1 --> 001
res1- 011

PERFORM XOR of num1,num2 and num3
2 --> 010
1 --> 001
3 --> 011
res2- 000

so IF U NOTICE --> aapko ye observation milegi ki,
har ek position pe result ke andar jo bit ko hum likh rahe hai woh iss baat pe depend karta hai ki kitna elements mein uss position pe 1 aaya hai

CONCLUSION --> If it is ODD NUMBER of 1's than result bit mein uss position pe 1 aayega and IF EVEN NUMBER of 1's than in that case 0 aayega 

PERFORM XOR of num1,num2 and num3
2 --> 010
1 --> 001
3 --> 011
4 --> 100
res - 100 (FINAL XOR value)
k value --> 001
so aap ye cheez kar sakte ho ki FINAL XOR and k value ke har ek bit ko compare karo if they are not equal that means uss position pe (EK ONE ka issue hai) means BIT FLIPPING karni hogi uss position pe kisi ek element ke in array
so simply jitne positions pe BITS equal nhi hai unke count lelo wahi at the end MINIMUM NUMBER OF OPERATIONS batayega

So code mein hum iss cheez ko kaise achieve karenge
step1 --> FINAL XOR nikalenge har ek number ka XOR karke , har ek number ke saath
step2 --> Than XOR karenge k ki value ko and FINAL XOR ko
step3 --> now ek iterator hoga jiska value 1 hoga initially and iske help se main har ek position pe AND operation karke count of 1 nikalunga jisse mujhe minimum number of operations mil jaayenge

*/
class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor = xor^nums[i];
        }
        //now calculating final xor
        int finalXOR = xor^k;
        int minOpr = 0;
        int iterator = 1;
        while(iterator<=finalXOR){
            if((iterator & finalXOR)!=0){
                //means uss position pe k and finalXOR mein mismatch hai nhi toh 0 aata 
                minOpr++;
            }
            iterator = iterator<<1;//means left shift karo 1 ko har ek iteration mei so that har ek position ke saath checking ho bit ki
        }
        return minOpr;
    }
}
