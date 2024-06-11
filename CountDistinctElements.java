pblm link --> https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1

class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int i=0;
        int j=k-1;
        //pehle starting window size ka create krlo and map mei put krdo
        for(int a=i;a<=j;a++){
            hmap.put(A[a],hmap.getOrDefault(A[a],0)+1);
        }
        list.add(hmap.size());
        //now window ke size ko constant rakhte hue last element tak jaao and distinct elements ka set find karo har ek window mei
        while(j<n){
            int ele = A[i];
            //frequency decrease krdo jo i ptr pe hai
            hmap.put(ele,hmap.getOrDefault(ele,0)-1);
            //agar frequency 0 ho gayi toh remove krdo
            if(hmap.get(ele)==0){
                hmap.remove(ele);
            }
            i++;
            j++;
            if(j<n){
              ele = A[j];
             //frequency increase krdo jo j ptr pe hai jo element
             hmap.put(ele,hmap.getOrDefault(ele,0)+1);
             list.add(hmap.size());
            }
        }
        return list;
    }
}
