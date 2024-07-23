Time Complexity --> O(n logn)
Space Complexity --> O(n)
pblm link --> https://leetcode.com/problems/sort-array-by-increasing-frequency/?envType=daily-question&envId=2024-07-23
class Solution {
    public int[] frequencySort(int[] nums) {
        //simply comparator design krdo 
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int num : nums){
            hmap.put(num,hmap.getOrDefault(num,0)+1);
        }
        Comparator<Integer> comp = new Comparator<Integer>(){
            @Override
            public int compare(Integer key1,Integer key2){
                int f1 = hmap.get(key1);
                int f2 = hmap.get(key2);
                if(f1!=f2){
                    //agar frequency 2 elements ki same nhi hai
                    //toh usko sort krdo on the basis of frequency value
                    return Integer.compare(f1,f2);
                }
                else{
                    //if frequency is same that key ke actual value ke basis pe sort krdo in DESCENDING ORDER
                    return Integer.compare(key2,key1);
                }
            }
        };
            TreeMap<Integer,Integer> tmap = new TreeMap<>(comp);
            tmap.putAll(hmap);
            int[] ans = new int[nums.length];
            int idx = 0;
            for(Map.Entry<Integer,Integer> entry : tmap.entrySet()){
                //ab simply map ko traverse kro and than ans array mei values ko place krdo along with their frequency count
                int freq = entry.getValue();
                int val = entry.getKey();
                for(int i=0;i<freq;i++){
                    ans[idx] = val;
                    idx++;
                }
            }
            return ans;
    }
}
