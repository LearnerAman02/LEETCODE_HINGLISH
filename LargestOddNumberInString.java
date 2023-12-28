package LEETCODE;
import java.util.*;
public class LargestOddNumberInString {
  // PBLM LINK : https://leetcode.com/problems/largest-odd-number-in-string/description/
  // Eg-1 I/P --> "52" ------ O/P - "5"
  // Eg-2 I/P --> "4602" ---- O/P - "4602"
  // Eg-3 I/P --> "3547" ---- O/P - "3547"
  // Traverse the string from end and pick the character and check karo ki kya woh odd character hai yaa nhi 
  // if it is ODD than waha tak ka substring lelo
  // And woh aapka longest odd number substring

  // coding 
  public static String largestOdd(String s){
    if((int)(s.charAt(s.length()-1))%2==1) return s;// entered string hi largest odd number hai
    String ans ="";
    for(int i=s.length()-2;i>=0;i--){
      if((int)(s.charAt(i))%2==1){
        ans = s.substring(0, i+1);
        break;
      }
    }
  return ans;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number string : ");
    String s = sc.nextLine();

  }
}

// T.C. ---> O(N)
