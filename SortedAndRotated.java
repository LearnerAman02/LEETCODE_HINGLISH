// pblm Link --> https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
// My brute force approach --> hum rotated function create karenge and than uske andar we will have our logic of rotation of array
// and for checking ki kitne se rotation ho raha hai, we will have a for loop [1,length of array] 
// once at any point function se true return hota hai than simply return true and come out of the loop ELSE if execution is finished we will have to return FALSE
// NOTE --> IMPORTANT UNDERSTANDING
// 1 - Har ek baar loop mein we will have to sort the nums array because if we don't do that than agle call mein modifed array paas hoga not the sorted arraya and uss modified array ke respect mein rotation will happen
// 2 - ek new array mein we will have to clone the rotated nums array jo starting mein given hai as parameter because if we do array=nums than reference dono ka same ho jaayege and change done in array bhi same nums array ko reflect karega 
// and agar actual answer false hota toh bhi true aata because dono ka reference is same
// 3 - return karao Arrays.equals(arr1,arr2) because tabhi actual values will be compared else agar humne arr1==arr2 kiya toh sirf reference comparion hoga
class Solution {
    boolean rotated(int []arr1,int arr2 [],int k){
        // we are considering it as left rotation
        // creating temparr for storing first k rotated values
        k=k%arr1.length;
        int tempArr[] = new int[k];
        for(int i=0;i<k;i++){
            tempArr[i] = arr1[i];
        }
        // now bringing the end elements into the front
        for(int j=k;j<arr1.length;j++){
            arr1[j-k] = arr1[j];
        }
        // now finally placing the tempArr values in the back side
        for(int i=0;i<k;i++){
            arr1[arr1.length-k+i] = tempArr[i];
        }

        System.out.println(Arrays.toString(arr1));
        return Arrays.equals(arr1,arr2);
    }
    public boolean check(int[] nums) {
        int array[] = nums.clone();
        boolean isRotated = false;
        for(int i=1;i<=nums.length;i++){
            Arrays.sort(nums);
            isRotated = rotated(nums,array,i);
            if(isRotated) return true;
        }
        return isRotated;
    }
}
