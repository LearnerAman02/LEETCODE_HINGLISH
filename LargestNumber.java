package LEETCODE;
import java.util.*;
public class LargestNumber {
  // refer to pblm statement here :
  // Link : https://leetcode.com/problems/largest-number/description/
  // Eg. arr = [3,330,34,6,7,9] ---> Output --- "976343330"(largest number)
  // APPROACH -->
  // 1) We will be converting the int array into String array
  // JAVA mei we can do it by directly using String.valueOf(arr[i]) method OR String str = arr[i]+""(AUTOMATIC TYPE PROMOTION)
  // 2) And than we will sort the array using Arrays.sort(arr) ------- { Normal sorting method of java will sort this array in LEXICOGRAPHICAL ORDER }
  // ARRAY AFTER SORTING ---- [3,34,330,6,7,9] 
  // But yaha pe ye issue hai ki when we will generate the final String than larget number will be "976330343"
  // Actual greatest number is -- "976343330"
  // 3) So isiliye when we will sort the array we will compare the numeric values jo badi hogi uss starting string ko we will keep at back
  // Eg. [34,330] -- [a,b]
  // String num1 = Long.parseLong(a+b) and String num2 = Long.parseLong(b+a) ----- combining string values and converting it into long so that hum check kar sake kaunsi value badi hai
  // if(num1>num2) means a pichhe aayega in array and b uske aage 
  // else iska ulta
  // 33034 (b+a) < 34330 (a+b) means in final sorted array ---- [330,34] (a baadmein aayega and b pehle)

  // So hum along with array.sort() method array ke saath ek lambda function(comparator) ko bhi pass karenge
  // Arrays.sort(arr,(a,b)->{ 
  //   long num1 = Long.parseLong(a+b);   long num2 = Long.parseLong(b+a); if(num1>num2) return 1; else if(num1<num2) return -1;  else return 0;
  // 1 - indicates a comes after b
  //-1 - indicates b comes after a
  // 0 - means no change, cheezon ko rakho as it is
  //})
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size of array : ");
    int m = sc.nextInt();
    int arr[] = new int[m];
    for(int i=0;i<m;i++){
      System.out.print("Enter value "+(i+1)+" : ");
      arr[i] = sc.nextInt();
    }
    // printing the int array
    System.out.println(Arrays.toString(arr));

    // now writing logic for creating the largest number
    // converting int array into string array
    String str[] = new String[m];
    for(int i=0;i<arr.length;i++){
      String s = String.valueOf(arr[i]);
      str[i] = s;
    }

  // now sorting logic
  Arrays.sort(str,(a,b)->{
      Long num1 = Long.parseLong(a+b);
      Long num2 = Long.parseLong(b+a);
      if(num1>num2){
        return 1;
      }else if(num1<num2){
        return -1;
      }else{
        return 0;
      }
    });

    // printing final required sorted array
    System.out.println(Arrays.toString(str));

    // now final ans 
    String ans ="";
    for(int i=str.length-1;i>=0;i--){
      ans = ans + str[i];
    }
    System.out.println("Largest number is : "+ans);
  }
}
