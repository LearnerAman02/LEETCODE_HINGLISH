//pblm link --> https://leetcode.com/problems/pass-the-pillow/description/?envType=daily-question&envId=2024-07-06
//T.C. --> O(n)
//S.C. --> O(n)
class Solution {
    public int passThePillow(int n, int time) {
        Stack<Integer> st = new Stack<>();
        //aap pehle QUOTIENT nikalo aur usko check kro ki kya woh EVEN hai yaa ODD 
        //agar even aata hai toh iska matlab hai abhi hum pillow ko pass kr rahe hai [1-->n] ki taraf
        //but agar ODD aata hai toh iska meaning hai ki pillow [n-->1] ki taraf pass ho rhi hai
        int temp = n;
        n--;
        int val = time/n;
        int rem = time%n;
        //initially tack mei push karado 1 ko kyunki initially first position waale bande ke hand mei pillow hai
        st.push(1);
        if(val%2==1){
            //number of rounds odd aaya hai iska matlab hum [1-->n] jaa chuke hai aur ab [n-->1] aana start karenge
            for(int i=2;i<=temp;i++){
                st.push(i);
            }
            int i=0;
            //ab [n-->1] aa rahe hai toh remaining time tak pichhe jaate jao
            //means stack ke cotent ko pop krte jaao
            while(i<rem){
                st.pop();
                i++;
            }
            return st.peek();
        }
        else{
            //push krte jaao stack mei values ko kyunki [1-->n] ki taraf pillow ka direction hai
            for(int i=1;i<=rem;i++){
                st.push(i+1);
            }
            return st.peek();
        }
    }
}
