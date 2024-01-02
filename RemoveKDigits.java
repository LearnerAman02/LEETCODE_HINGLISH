package LEETCODE;
import java.util.*;
import java.util.Arrays;
import java.util.Stack;

// PBLM LINK :- https://leetcode.com/problems/remove-k-digits/description/
/*
APPROACH --->
Example - String s = "1432219",k=3
smallest number form karna hai by removing k digits
Thought process --
start iteration from character at 0 th index and push it into the stack
Now check karo jo next aane wala element hai kya woh smaller hai than stack.peek() element than pop that element out and decrease k value and than push this current character into the stack
We will use STACK DATA STRUCTURE to implement this
 */
public class RemoveKDigits {
  public static String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack();
        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            while(!s.isEmpty() && k>0 && s.peek()>ch){
                k--;
                s.pop();
            }
            s.push(ch);
        }
        // if k has not become zero yet keep poping out
        while(!s.isEmpty() && k>0){
                k--;
                s.pop();
        }
        if(s.isEmpty()){
            return "0";
        }
        int n = s.size(); // size of stack
        char ansChar[] = new char[s.size()];
        // now placing the characters of stack in an array 
        for(int i=n-1;i>=0;i--){
            ansChar[i] = s.pop();
        }
        System.out.println(Arrays.toString(ansChar));
        String ans = "";
        // leading zeroes ko neglect kro
        int idx = 0;
        for(int i=0;i<n;i++){
            if(ansChar[i]=='0'){
                idx = i+1;
            }else{
                break;
            }
        }
        // if index becomes equal to size of array after neglecting all the leading zeroes than simply return 0
        if(idx==n){
            return "0";
        }
        for(int i=idx;i<n;i++){
            ans = ans + ansChar[i];
        }
        return ans;
    }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your String : ");
    String s = sc.nextLine();
    System.out.print("Enter number of digits to be removed : ");
    int k = sc.nextInt();
    String smallestValue = removeKdigits(s, k);
    System.out.println("Smallest string value is : "+smallestValue);
  }
}
