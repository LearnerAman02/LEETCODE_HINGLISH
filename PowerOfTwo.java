// pblm link -->https://leetcode.com/problems/power-of-two/description/
// let us suppose aapko 32 banana hai , so in that case 
//    0  1   0 0 0 0 0  ---> that means we require 5 times left shift of bit at 2 power 0
//    64 32 16 8 4 2 1
// and left shift can be simply done using (1<<n) --> n - number of times to shift
// Above logic can be used to generate number which is power of 2
// But we have to check whether the number is divible by 2 or not
// Eg --> 16(n)
// BINARY REPRESENTATION -->  1 0 0 0 0
// 15 is n-1
// BINARY REPRESENTATION -->  0 1 1 1 1
// That means AND of n and n-1 will be 0 , and in that case our number (n) will be power of 2
class Solution {
    public boolean isPowerOfTwo(int n) {

        if(n == 0 || n == Integer.MIN_VALUE){
            return false;
        }
        int a = n&(n-1);
        System.out.println("a : "+a);
        if(a==0){
            return true;
        }
        else{
            return false;
        }
    }
}
