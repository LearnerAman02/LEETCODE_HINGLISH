// pblm link --> https://leetcode.com/problems/rotate-array/
// BRUTE FORCE APPROACH --> 
// RAAZ KI BAAT -- Agar hum left rotate ka logic bana diye hai toh agar hume k times right rotation perform karna hai toh it is similar to perform LEFT ROTATION for array length - k times
// lets understand it through example
// perform right rotation for k=3
// Array --> [1,2,3,4,5,6,7] 
// k=1 (rotation 1)
// [7,1,2,3,4,5,6]
// k=2 (rotation 2)
// [6,7,1,2,3,4,5]
// k=3 (rotation 3)
// [5,6,7,1,2,3,4] ---> final array 1
// Now I say that perform left rotation for k = arr.length-k i.e. k=4
// Array --> [1,2,3,4,5,6,7] 
// rotation 1 --> [2,3,4,5,6,7,1]
// rotation 2 --> [3,4,5,6,7,1,2]
// rotation 3 --> [4,5,6,7,1,2,3]
// rotation 4 --> [5,6,7,1,2,3,4] --> final array 2
// so u can se that final array 1 = final array 2
// so hum hum ye keh sakte hai ki perform k times right rotation or perform left rotation for (array ka length - k) times
// so in my rotated function I have written the logic for left rotation 
class Solution {
    void rotated(int []arr1,int k){
        // we are considering it as left rotation
        // creating temparr for storing first k rotated values
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
    }
    public void rotate(int[] nums, int k) {
        k = k%nums.length;// important to do kyunki rotation get repeated after every k%array length interval
        k = Math.abs(nums.length-k);
        System.out.println(k);
        rotated(nums,k);
    }
}
