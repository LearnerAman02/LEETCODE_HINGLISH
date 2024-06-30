//T.C. --> O(nlogn)
//S.C. --> O(n)
import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] sortByFrequency(int[] nums) {
    //ek pair naam ka custom class bana rahe hai, jisko hum PriorityQueue mei store karayenge
    class Pair{
        int num;
        int f;
        public Pair(int n,int f){
            this.num = n;
            this.f = f;
        }
    }
    
    //ek map pehle create krte hai jisme hum frequency of each element store karayenge
    HashMap<Integer,Integer> hmap = new HashMap<>();
    
    //second hashmap jisme hum element aur uske index kjo store karayenge
    HashMap<Integer,Integer> imap = new HashMap<>();

    //ye hai hamari comparator , jiske method ko hum override kar rahe hai, and OWN LOGIC define kr rahe hai so that jab PriorityQueue elements ko place kre MAX HEAP ke andar than uss case mei hamare comparator ke logic ke basis pe kare
    Comparator<Pair> comp = new Comparator<Pair>(){
        @Override
        public int compare(Pair p1,Pair p2){
            if(p1.f!=p2.f){
                return Integer.compare(p2.f,p1.f);
            }
            else{
                return Integer.compare(imap.get(p1.num),imap.get(p2.num));
            }
        }
    };
    
    //ab PriorityQueue create kro and jo values lega as that of the Pair class and custom comparator ko usme pass krdo for placing the elements
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>(comp);
    for(int i=0;i<nums.length;i++){
        int num = nums[i];
        hmap.put(num,hmap.getOrDefault(num, 0)+1);
        if(!imap.containsKey(num)){
            imap.put(num,i);
        }
    }

    //ab hmap(freuquency map) ko traverse kro and QUEUE ke andar place krdo values ko
    for(Map.Entry<Integer,Integer> entry: hmap.entrySet()){
        int f = entry.getValue();
        int n = entry.getKey();
        pq.offer(new Pair(n, f));
    }
    int[] ans = new int[nums.length];
    int idx=0;
    while(!pq.isEmpty()){
        Pair p = pq.poll();
        int freq = p.f;
        int val = p.num;
        for(int i=0;i<freq;i++){
            ans[idx++] = val;
        }
    }
    return ans;
    }
}
