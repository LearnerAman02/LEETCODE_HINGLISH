package LEETCODE;
import java.util.*;
public class RotateMatrix {
  // PBLM --- ROTATE THE IMAGE BY 90 DEGREE
  // see the pblm statement here
  // link : https://leetcode.com/problems/rotate-image/description/
  // APPROACH --->
  // Optimal ki baat krta hoon 
  // S-1 ---> Take Transpose of matrix 
  // S-2 ---> Transpose lene ke baad arr.length/2 tak traverse krke just reverse the values
  // ODD or EVEN Number of columns  --- { In this case run loop from i=0 to i<col.length/2  and inner loop j=0 to j<row.length and just swap the values i.e FIRST COL ki values ko swap karo with LAST COL ki values, SECOND COL ki values ko swap karo with SECOND LAST COL ki values ke saath and so on....}
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of rows : ");
    int r = sc.nextInt();
    System.out.print("Enter the number of columns : ");
    int c = sc.nextInt();
    int matrix [][] = new int [r][c];
    // taking user input for the matrix filling
    for(int i=0;i<r;i++){
      for(int j=0;j<c;j++){
        System.out.print("Enter the value ["+(i+1)+"]"+"["+(j+1)+"] :");
        matrix[i][j] = sc.nextInt();
      }
    }
    // first we are writing the logic for TRANSPOSE OF MATRIX
        // nested for loop i -- (0-row-2) and j -- (1 - col-1)
        // NOTE --> We are not traversing the entire matrix
        // ye niche wala loop for transposing the matrix sirf upper triangular matrix ke liye hi chal raha hai 
        for(int i=0;i<matrix.length-1;i++){
          for(int j=i+1;j<matrix[0].length;j++){
              if(i!=j){
                  // swap
                  int temp = matrix[i][j];
                  matrix[i][j] = matrix[j][i];
                  matrix[j][i] = temp;
              }
          }
        }

      // now reversing the column values
      // i ko chalayenge col/2 tak and internally har ek row se travel karne ke liye we will use j
      // and har ek iteration we will swap 
      for(int i=0;i<matrix[0].length/2;i++){
        // swap
        for(int j=0;j<matrix.length;j++){
            int temp = matrix[j][i];
            matrix[j][i] = matrix[j][matrix[0].length-1-i];// matrix[0].length-1-i karna hoga har ek itertion mein column value will differ
            matrix[j][matrix[0].length-1-i] = temp;
        }
      }
      
  }
}
