// pblm link --> https://www.geeksforgeeks.org/problems/quick-sort/1
class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low>=high){
            return;
        }
        int p = partition(arr,low,high);
        quickSort(arr,low,p-1);
        quickSort(arr,p+1,high);
    }
    static int partition(int arr[], int low, int high)
    {
        int idx = low;
        //take a pivot
        int pivot = arr[low];
        int count = 0;
        //find the correct position of pivot
        for(int i=low+1;i<=high;i++){
            if(arr[i]<=pivot){
                count++;
            }
        }
        
        int pIdx = low+count;
        //swap krdo low index pe jo element hai aur pivot ko usko right index pe
        int temp = arr[pIdx];
        arr[pIdx] = arr[low];
        arr[low] = temp;
        
        //now pivot se chhote elements ko pivot se pehle place karo and pivot se bade pivot ke baad
        int i=low;
        int j=high;
        while(i<pIdx && j>pIdx){
            while(arr[i]<=pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            if(i<pIdx && j>pIdx){
                //swap krdo
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return pIdx;
    } 
}
