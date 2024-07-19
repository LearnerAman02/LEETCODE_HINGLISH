class Solution {
    static Long gcd(Long a, Long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    static Long lcm(Long a,Long b){
        return (a*b)/gcd(a,b);
    }
    static Long[] lcmAndGcd(Long A , Long B) {
        Long[] ans = new Long[2];
        ans[0] = lcm(A,B);
        ans[1] = gcd(A,B);
        return ans;
    }
};
