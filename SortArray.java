//hum array ko sort karenge using MERGE SORT logic 
// ye  ek DIVIDE and CONQUER strategy hai 
// break current big pblm to smaller problems and keep on solvong those smaller sub problems which in turn will help u to solve actual bigger pblm
Time Complexity --> O(n logn) and Space Complexity --> O(n)
class Solution {
    public void merge(int[] arr,int s,int m,int e,int b[]){
        int i=s;
        int j=m+1;
        int k=s;
        while(i<=m && j<=e){
            if(arr[i]<arr[j]){
                b[k] = arr[i];
                i++;
            }
            else{
                b[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<=m){
            b[k] = arr[i];
            i++;
            k++;
        }
        while(j<=e){
            b[k] = arr[j];
            j++;
            k++;
        }

        for(k=s;k<=e;k++){
            arr[k] = b[k];
        }
    }
    public void mergeSort(int[] arr,int s,int e,int[] b){
        if(s<e){
            int m = s+(e-s)/2;
            //keep on dividing the pblm
            mergeSort(arr,s,m,b);
            mergeSort(arr,m+1,e,b);
            //while merging the array, sort the array first and than backtrack
            merge(arr,s,m,e,b);
        }
    }
    public int[] sortArray(int[] nums) {
        int[] b = new int[nums.length];
        mergeSort(nums,0,nums.length-1,b);
        return nums;
    }
}
