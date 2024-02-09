// pblm link --> https://www.codingninjas.com/studio/problems/count-of-greater-elements-to-the-right_8365436?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
// we have to find the count of next greater element to the right of current elemnt
// BRUTE FORCE --> ek extra array create karo and now traverse the given array and check karo ki kitne greater element
// is present ahead of it and store that count for each value in the array
// after that just find the number using query array and return its count
public class Solution {
    public static int[] countGreater(int []arr, int []query) {
        int n = arr.length;
        int m = query.length;
        //int ansArr[] = 
        int countArr[] = new int[n];
        for(int i=0;i<n-1;i++){
            int num =arr[i];
            int greater = 0;
            for(int j=i+1;j<n;j++){
                if(arr[j]>num){
                    greater++;
                }
            }
            countArr[i]=greater;
        }
        // last index pe jo value hai uska 0 hi hoga
        countArr[n-1]=0;
        // print count arr

        // now traversing the query array and getting the value idx and storing its count in query array
        for(int i=0;i<m;i++){
            int idx = query[i];// getting the required index of arr[]
            query[i] = countArr[idx];// storing the value in query
        }

        return query;
    }
}
