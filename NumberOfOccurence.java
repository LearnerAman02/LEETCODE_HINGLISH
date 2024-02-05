// pblm Link --> https://www.codingninjas.com/studio/problems/occurrence-of-x-in-a-sorted-array_630456?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
// brute force --> O(n) 
// Ek count variable lo and start travesrsing the array if that element is pointed than increment value of count
// Optimal Approach --> Using concept of BINARY SEARCH + FIRST OCCURENCE and LAST OCCURENCE -- T.C. - O(logN)
// FIRST Occurence approach -- dekho we all know how to do binary search and our mid variable points to it if target variable is present in array
// Now agar hume uska first occurence chahiye than target milne ke baad also we will have to search in left part of the array because ye possibility hai ki current idx position uska first occurence position naa ho
// Example se understand karo -
// [1,1,2,2,3,4,5,6] - target = 3
//  s     m       e   arr[m]<target so search right
// [1,1,2,2,3,4,5,6] - target = 3
//          s m   e   arr[m]>target so search left
// [1,1,2,2,3,4,5,6] - target = 3
//          s     arr[m]==target so search ye possible idx hai of 3
//          e,m
// but ab ye samjho ki above array aisa hota [1,1,2,3,3,3,5,6]
// toh hume ek occurence milta 3 ka but ho sakta tha ki woh first occurence na ho so that's why jab mid hamare target element ko point karega
// in that case hum end ko update karenge as {end = mid-1} to find the first occurence
// and similarly jab last occurence find karna hoga than hum {start = mid+1} karenge kyunki target element ka ek possible position mila hai but aage aur bhi occurences ho sakte so for that update start=mid+1
// NOTE --> First occurence and last occurence dono ke liye we will use differnt binary search function
// now occurences milne ke baad we will get range ki hamara target element array mein kaunse idx se lekar kaha tak lie kar raha hai
// and there fore total occurence = lastOcc - firstOcc +1
// [1,1,2,3,3,3,5,6]
//  0 1 2 3 4 5 6 7
//        f   L
// total occurence = f-L +1 = 3
public class Solution {
    public static int bsFirstOcc(int arr[],int x,boolean first){

     int s=0;

     int e = arr.length-1;

     int idx =-1;

     while(s<=e){

       int m = e+(s-e)/2;

       if(arr[m]==x){

         //return true;

         if(first){
           idx=m;
           e=m-1;

         }else{

           break;

         }

       }

       else if(arr[m]>x){

         e=m-1;

       }else{

         s=m+1;

       }

     }

     return idx;

   }

   

   public static int bsLastOcc(int arr[],int x,boolean first){

     int s=0;

     int e = arr.length-1;

     int idx =0;

     while(s<=e){

       int m = e+(s-e)/2;

       if(arr[m]==x){

         if(!first){
           idx=m;
           s=m+1;

         }else{

           break;

         }

       }

       else if(arr[m]>x){

         e=m-1;

       }else{

         s=m+1;

       }

     }

     return idx;

   }
    public static int count(int arr[], int n, int x) {
     int idx1 = bsFirstOcc(arr,x,true);
     //System.out.println("First Occurence : "+idx1);
     if(idx1==-1){// that means element is not present in the array
       return 0;
     }
     int idx2 = bsLastOcc(arr,x,false);

     int total = idx2-idx1+1;

     return total;
        //Your code goes here
    }
}
