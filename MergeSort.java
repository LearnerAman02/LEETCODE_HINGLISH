package LEETCODE;

import java.util.Arrays;

public class MergeSort {
    // SIMPLE MERGE SORT CODE ----
    public static void merge(int arr[],int s,int m,int e){
        // extra space for storing the sorted value
        int b[] = new int[arr.length];
        int i=s;
        int j = m+1;
        int k=s;
        while(i<=m && j<=e){
            if(arr[i]<arr[j]){
                b[k++] = arr[i++];
            }else{
                b[k++] = arr[j++];
            }
        }

        while(i<=m){
            b[k++] = arr[i++];
        }

        while(j<=e){
            b[k++] = arr[j++];
        }

        //k = s;
        // now copying the value into original array
        for(k=s;k<=e;k++){
            arr[k] = b[k];
        }
    }


    // Merge sort ke Merge logic se, we can solve MERGE SORT,GLOBAL INVERSION aka (COUNT INVERSION)
    // global inversion basically indicate krta hai number of inversions jo ki required hai array ko sort hone liye
    // global inversion means arr[i]>arr[j] where i<j
    // PBLM LINK : https://leetcode.com/problems/global-and-local-inversions/description/
    // for global inversion
    // consider an array --- nums = [8,5,3,4,1,6,2]
    //         RECURSIVE TREE
    //                     (arr,0,6)
    //                   /           \
    //           (arr0,3)             (arr,4,6)
    //         /         \           /        \
    //   (arr,0,1)   (arr,2,3)  (arr,4,5)     (arr,6,6){base case}
    //  /        \   /       \   /      \     
    //(arr,0,0) (arr,1,1) .............. Baaki samajhdaar ho aap :):)
    // [8]      [5]   [3]    [4]  [1]   [6]    [2]
    // Now merging ke time we will compare the values and count the number of global inversions and than return the sorted array to the previous call
    //  8>5 (true) means it is 1 global inversion
    //  3>4 (false) -- that means no increment in global inversion count
    // jab merge hoke array return hoga to the left call -- (arr,0,1) it will contain [5,8]
    // jab merge hoke array return hoga to the right call -- (arr,2,3) it will contain [3,4]
    // now hume [5,8] and [3,4] inn arrays par apply karna hai merge procedure ko
    //      [5,8]   [3,4]
    //       i       j       ---- is (arr[i]>arr[j]) {true} than global inversion ke count mein mid-i+1 add kardo kyunki dekho jispe i point kar raha hai woh value agar greater hai than j jisko point kar raha hai toh i waale array mein uske aage ke saare elements bhi arr[j] waale se bade honge (because array is sorted) and uske baad j++; else do not increment global inversion count and simply i++
    // NOTE ---> DRAW AND VISUALIZE THAN ONLY, YE POINT BAHOT ACHHE SE CLEAR HOGA

    // REAPEAT THE SAME PROCESS TILL WE GET FINAL SORTED ARRAY

    // Code for global inversion count
    public static int globalInvCount = 0;
    public static void globalInversion(int arr[],int s,int m,int e){
        // extra space for storing the sorted value
        int b[] = new int[arr.length];
        int i=s;
        int j = m+1;
        int k=s;
        // below one extra while loop for global inversion
        while(i<=m && j<=e){
            if(arr[i]>arr[j]){
                j++;
                globalInvCount += m-i+1;
            }else{
                i++;
            }
        }

        i = s;
        j = m+1;
        while(i<=m && j<=e){
            if(arr[i]<arr[j]){
                b[k++] = arr[i++];
            }else{
                b[k++] = arr[j++];
            }
        }

        while(i<=m){
            b[k++] = arr[i++];
        }

        while(j<=e){
            b[k++] = arr[j++];
        }

        //k = s;
        // now copying the value into original array
        for(k=s;k<=e;k++){
            arr[k] = b[k];
        }
    }


    public static void mergesort(int arr[],int l,int h){
        if(l==h){
            return;
        }else{
            int mid = l+(h-l)/2;
            mergesort(arr, l, mid);
            mergesort(arr, mid+1, h);
            globalInversion(arr, l, mid, h);
        }
    }

    // merge procedure to sort an array
    // s- start, m- mid, e - end
    public static void main(String[] args) {
        int nums[] = {8,5,3,4,1,6,2};
        // int nums[] = {2,0,1};
        //mergesort(nums, 0, 6);
        System.out.println(Arrays.toString(nums));
        mergesort(nums, 0, 6);
        System.out.println(Arrays.toString(nums));
        System.out.println(globalInvCount);
    }
}
