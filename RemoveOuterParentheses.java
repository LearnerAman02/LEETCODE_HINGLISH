https://leetcode.com/problems/remove-outermost-parentheses/
// Optimal approach --> string ko traverse karenge and jab bhi hum encounter karenge '(' hum pehle check karenge ki kya stack mein already '(' present h yaa nhi 
// if TRUE than hum '(' ko append karenge in final answer string kyunki woh outermost '(' nhi hai else nhi karenge usko append because woh final string hai
// now jab hum ')' ko encounter karenge than hum pop karenge pehle and check karenge ki stack empty toh nhi ho gaya hai 
// if STACK IS EMPTY means ')' character corresponding to outermost parantheses tha and isko apppend nhi karenge 
// if STACK IS NOT EMPTY means ')' character corresponding to outermost parantheses nhi hai and we have to append it in the final answer string
class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String ans = "";
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                if(st.size()>0){
                    ans += ch;
                }
                st.push(ch);
            }else{
                st.pop();
                if(st.size()>0){
                    ans += ch;
                }
            }
        }
        return ans;
    }
}
