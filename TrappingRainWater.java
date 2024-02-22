// pblm link --> https://leetcode.com/problems/trapping-rain-water/description/
// Logic --> water accumulation tabhi hoga jab current building se pehle usse chhoti building yaa badi building left yaa right mein ho
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int right [] = new int[n];
        int left [] = new int[n];
        int max = -1;
        //maximum water bigger building aur smaller building ke beech mein at max SMALLER BUILDING ke height tak hoga
        int maximumWater [] = new int[n];// this will store at max kitna water fill ho sakta hai w.r.t CURRENT building

        // storing current building ke pichhe maximum height wali building kaunsi hai
        for(int i=0;i<n;i++){
            max = Math.max(height[i],max);
            right[i] = max;
        }

        // storing current building ke aage maximum height wali building kaunsi hai  
        max = -1;
        for(int i=n-1;i>=0;i--){
            max = Math.max(height[i],max);
            left[i] = max;
        }

        // storing at max kitna water accumulate ho sakta hai w.r.t current building
        // which will be equal to smaller building height
        for(int i=0;i<n;i++){
            int min = Math.min(right[i],left[i]);
            maximumWater[i] = min;
        }
        System.out.println(Arrays.toString(maximumWater));
        int total =0;
      // finally subtracting maximumwater that can be accumulated with building ka height to get the actual trapped water
        for(int i=0;i<n;i++){
            int water = height[i]-maximumWater[i];
            //System.out.println()
            total += Math.abs(water);
        }
        return total;
    }
}
