Time and Space Complexity --> O(n*m) 
n --> number of elements in string and m --> size of each number in the array
class Solution {
    public int[] sort(int[] mapping, int[] nums){
        // Convert nums array to string array
        int n = nums.length;
        String[] str = new String[n];
        for(int i = 0; i < n; i++){
            str[i] = String.valueOf(nums[i]);
        }

        // Map to store the new mapped values
        HashMap<Integer, String> hmap = new HashMap<>();
        for(int j = 0; j < n; j++){
            String num = str[j];
            String newNum = "";
            for(int i = 0; i < num.length(); i++){
                // Pick the character and convert to integer for mapping
                char ch = num.charAt(i);
                int val = Character.getNumericValue(ch);
                // Get the mapped value from mapping index and append to newNum string
                int mapped = mapping[val];
                newNum += String.valueOf(mapped);
            }
            hmap.put(j, newNum);
        }

        // Comparator to compare values based on the mapped values
        //mera comparator basically newly mapped values ko compare kr rha hai 
        // if they are not same than place the maximum one first else place on the basis of index values
        Comparator<Integer> comp = new Comparator<Integer>(){
            public int compare(Integer key1, Integer key2){
                String s1 = hmap.get(key1);
                String s2 = hmap.get(key2);
                int num1 = Integer.valueOf(s1);
                int num2 = Integer.valueOf(s2);
                if(num1 != num2){
                    return Integer.compare(num1, num2);
                } else {
                    return Integer.compare(key1, key2);
                }
            }
        };

        // PriorityQueue to sort based on the comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
        pq.addAll(hmap.keySet());
        
        int[] fans = new int[n];
        int idx = 0;
        while(!pq.isEmpty()){
            int key = pq.poll();
            fans[idx] = nums[key];
            idx++;
        }
        return fans;
    }
    
    public int[] sortJumbled(int[] mapping, int[] nums) {
        return sort(mapping, nums);
    }
}
