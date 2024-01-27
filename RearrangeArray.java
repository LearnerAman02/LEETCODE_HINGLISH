// Brute Force --> identify positive numbers and negative numbers and store karte jao in positive array and in negative array and than traverse karo like merge procedure logic in merge sort
class Solution {
    public int[] rearrangeArray(int[] nums) {
        // creating 2 array 
        int posArr[] = new int[nums.length/2];
        int negArr[] = new int[nums.length/2];
        // now iterating and keeping elements in corresponding array
        int idxCount =0;
      // storing positive elements in posArr
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                posArr[idxCount]=nums[i];
                idxCount++;
            }
        }
        idxCount =0;
      // storing negative elements in negArr
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                negArr[idxCount]=nums[i];
                idxCount++;
            }
        }
        System.out.println("positive array : "+Arrays.toString(posArr));
        System.out.println("negative array : "+Arrays.toString(negArr));
        int p=0;// for tracking elements stored in positive array
        int n=0;// for tracking elements stored in negative array
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=posArr[p];
                p++;
            }else{
                nums[i]=negArr[n];
                n++;
            }
        }
        return nums;
    }
}
