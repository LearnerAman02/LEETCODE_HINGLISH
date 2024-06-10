// pblm link --> https://leetcode.com/problems/height-checker/description/?envType=daily-question&envId=2024-06-10
// T.C. --> O(nlogn) and S.C. --> O(n) in both appproach
//APPROACH 1 - using sorting
class Solution {
    public int heightChecker(int[] heights) {
        //BRUTE FORCE --> simply SORT krdo and than ek pointer chalake mismatch value count krlo
        int a[] = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            a[i] = heights[i];
        }
        Arrays.sort(heights);
        int idx = 0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=a[i]){
                idx++;
            }
        }
        return idx;
    }
}

//APPROACH 2 - using MIN HEAP
class Solution {
    public int heightChecker(int[] heights) {
        //LITTLE BETTER using PRIORITY QUEUE
        //creating min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : heights){
            pq.offer(num);
        }
        int idx = 0;
        int count = 0;
        while(!pq.isEmpty()){
            if(heights[idx]!=pq.poll()){
                count++;
            }
            idx++;
        }
        return count;
    }
}

