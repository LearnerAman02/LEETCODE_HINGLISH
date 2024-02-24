/*
Question -->
Have the function ArrayChallenge (arr) read the array of integers stored in axx which will be in the following format: [K, r1, r2, 3, ...] where K represents the number of desks in a classroom, and the rest of the integers in the array will be in sorted order and will represent the desks that are already occupied. All of the desks will be arranged in 2 columns, where desk #1 is at the top left, desk #2 is at the top right, desk #3 is below #1, desk #4 is below #2, etc. Your program should return the number of ways 2 students can be seated next to each other. This means 1 student is on the left and 1 student on the right, or 1 student is directly above or below the other student.

For example: if arr is [12, 2, 6, 7, 11] then this classrooms looks like the following picture:

2
[2/9, 17:55] Utsav 🦁: Based on above arrangement of occupied desks, there are a total of 6 ways to seat 2 new students next to each other. The combinations are: [1, 3], [3, 4], [3, 5], [8, 10], [9, 10], [10, 12]. So for this input your program should return 6. K will range from 2 to 24 and will always be an even number. After K, the number of occupied desks in the array can range from 0 to K.

Once your function is working, take the final output string and concatenate it with your Challenge Token, and then replace every third character with an X.

Your ChallengeToken: 871 cuyzbm6a

Examples

Input: [6, 4]

Output: 4

Final Output: 48X1cXyzXm6X

Input: [8, 1, 8]

Output: 6

Final Output: 68X1cXyzXm6X
*/

// ----------------------------------------- SOLUTION FOR ABOVE 3 TEST CASES -----------------------------------------------------
// logic
/*
2D matrix banega with n/2 number of rows and 2 columns in each row where n is the number of desks 
[[d1,d2],
 [d3,d4],
 [d5,d6],
 [d7,d8]]
 now students can be placed right left (baju baju) mein or else up and bottom (aage pichhe)
 so for d3 possible combination for placing students are (d3,d4)-- (baaju baaju) and (d3,d1) -- aage pichhe 
eg - 1
[12,2,6,7,11] where 12 indicates total number of desks and 2,6,7,11 indicates kitne desks has been already occupied by the students , so remaining mein se we have to find possible combinations where students can be placed
for n = 12
n/2 = 6 i.e. 6 rows with 2 columns each
[[1,2],
 [3,4],
 [5,6],
 [7,8],
 [9,10],
 [11,12]]

 if 1D array ke according lena hai
 [[0,1],
 [2,3],
 [4,5],
 [6,7],
 [8,9],
 [10,11]]

 now same iske corresponding ek 1D boolean array banao of size n and jaha jaha bache baithe hai waha True store karo
 [F,T,F,F,F,T,T,F,F,F, T, F]
 [0,1,2,3,4,5,6,7,8,9,10,11]

 Now for finding number of combinations row ko traverse karo and check karo ki kaunsa right mein false and niche false hai in actual boolean array than take that combination if it is false and than mark it true in array

 */

import java.util.Arrays;

public class ArrangeStudents {
  public static int combinations(int arr[]) {
    int n = arr.length;
    int desks = arr[0];
    int rows = desks / 2;
    int combination = 0;
    // creating boolean array
    boolean occupiedDesk[] = new boolean[desks];
    for (int i = 1; i < n; i++) {
      // marking occupied desks as true
      int idx = arr[i];
      occupiedDesk[idx - 1] = true;
    }
    // printing occupied status
    System.out.println(Arrays.toString(occupiedDesk));

    // now creating travelling 2D matrix of arrangement of desks in a smarter way
    // with the help of 1D array only
    for (int i = 0; i < rows; i++) {
      int currDesk = 2 * i;// currentDesk in column 1
      if (occupiedDesk[currDesk] == false) {
        // check karo ki kya iska right desk yaa niche wala desk khaali hai
        if (occupiedDesk[currDesk + 1] == false) {
          combination++;
        }
        // make sure array index out of bound naa ho
        if (currDesk + 2 < 2 * rows && occupiedDesk[currDesk + 2] == false) {
          combination++;
        }
        occupiedDesk[currDesk] = true;
      }
      int currDesk2 = 2 * i + 1;
      if (occupiedDesk[currDesk2] == false) {
        // check karo ki kya iska left desk yaa niche wala desk khaali hai
        if (occupiedDesk[currDesk2 - 1] == false) {
          combination++;
        }
        // make sure array index out of bound naa ho
        if (currDesk2 + 2 < 2 * rows && occupiedDesk[currDesk2 + 2] == false) {
          combination++;
        }
        occupiedDesk[currDesk2] = true;
      }
    }
    return combination;
  }

  public static void main(String[] args) {
    int arr[] = { 12, 2, 6, 7, 11 };
    // int arr[] = { 8, 1, 8 };
    // int arr[] = { 6, 4 };

    // boolean array[] = new boolean[5];
    // System.out.println(Arrays.toString(array));
    int possibleCombo = combinations(arr);
    System.out.println(possibleCombo);
    String token = "871cuyzbm6a";

    // appending answer at the front of my token
    String ans = String.valueOf(possibleCombo);
    token = ans + token;
    System.out.println(token);

    // now replacing every third character with 'X'
    char strArray[] = token.toCharArray();
    for (int i = 0; i < strArray.length; i++) {
      if ((i + 1) % 3 == 0) {
        strArray[i] = 'X';
      }
    }
    // printing the modified array
    System.out.println(Arrays.toString(strArray));

    String finalStr = "";
    for (char ch2 : strArray) {
      finalStr += ch2;
    }

    System.out.println("My actual final Answer is : " + finalStr);
  }
}
