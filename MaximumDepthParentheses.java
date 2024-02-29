/*
pblm link --> https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
LOGIC --> string ko traverse karo and when u encounter ')'  check karo ki kya stack ke top pe '(' hai 
in that case u have traverse till certain depth of parenthesis and now if u will encounter ')' u will have to decrease the depth
and currDepth will be number of opening parenthesis till yet in the stack and just Update karlo maxDepth ki value

Now if things are not very much clear than don't worry main ek sample test case pe dry run karta hoon than u will get it easily
String --> "(1+(2*3)+((8)/4))+1"
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1" -- I have just used spaces so that I can show u the pointer movement in appropriate way
        i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - []  maxDepth = 0, currDepth = 0
since it is not closing parentheses just push it into stack
          i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['('] maxDepth = 0, currDepth = 0
now since i is not pointing to any parentheses just simply move i ptr without pushing or poping from stack
            i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['('] maxDepth = 0, currDepth = 0
              i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['('] maxDepth = 0, currDepth = 0
                i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['(','('] maxDepth = 0, currDepth = 0
                  i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['(','('] maxDepth = 0, currDepth = 0
                  i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['(','('] maxDepth = 0, currDepth = 0
                    i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['(','('] maxDepth = 0, currDepth = 0
                      i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['(','('] maxDepth = 0, currDepth = 0
now since we have encounter ')' that means 1 pair of valid parentheses has been found and size of stack hume abhi tak ka current maximum depth indicate kar raha hai 
so we will try to update actual maxDepth
                      i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['(','('] maxDepth = 2, currDepth = 2
now pop element from stack
                        i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['('] maxDepth = 2, currDepth = 2
                          i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['('] maxDepth = 2, currDepth = 2
                            i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['(','('] maxDepth = 2, currDepth = 2
                              i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['(','(','('] maxDepth = 2, currDepth = 2
                                i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['('] maxDepth = 2, currDepth = 2
now since we have encounter ')' that means 1 pair of valid parentheses has been found and size of stack hume abhi tak ka current maximum depth indicate kar raha hai 
so we will try to update actual maxDepth
currDepth = curr Size of stack therefore maxDepth = 2, currDepth = 3
and hence maxDepth will be updated to 3 and will pop one opening parentheses
                                  i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['(','('] maxDepth = 3, currDepth = 3
                                    i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['(','('] maxDepth = 3, currDepth = 3
                                      i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['(','('] maxDepth = 3, currDepth = 3
pop one opening since we have encounter closing
                                        i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - ['('] maxDepth = 3, currDepth = 1
                                          i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - [] maxDepth = 3, currDepth = 1
                                            i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - [] maxDepth = 3, currDepth = 1
                                              i
str = " ( 1 + ( 2 * 3 ) + ( ( 8 ) / 4 ) ) + 1"  -- Stack - [] maxDepth = 3, currDepth = 1
since we have traverse entire string break the loop
NOTE --> if aage sirf '(' or ')' aata without its proper pair than woh stack mein push hota and due to invalid pair
stack will not be empty 
so iska matlab hume maxDepth mila toh hai but valid parentheses string nhi so in that case we will return 0
else agar stack is empty toh just happily return maxDepth
*/
class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currDepth = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && s.charAt(i)==')' && st.peek()=='('){
                currDepth = st.size();
                maxDepth = Math.max(currDepth,maxDepth);
                st.pop();
            }
            else{
                if(s.charAt(i)=='('){
                    st.push(s.charAt(i));
                }
            }
        }
        System.out.println("Max Depth : "+maxDepth);
        if(st.isEmpty()){
            return maxDepth;
        }
        else{
            return 0;
        }
    }
}
