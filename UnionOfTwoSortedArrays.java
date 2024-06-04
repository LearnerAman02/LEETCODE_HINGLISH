//pblm link --> https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1
//T.C. --> O(N+M)
//S.C. --> O(N+M)
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        //simple logic ye hai ki TreeMap ka use karenge so that UNIQUE sorted elements store ho
        int i=0;
        int j=0;
        TreeMap<Integer,Integer> tmap = new TreeMap<>();
        while(i<n && j<m){
            if(arr1[i]<=arr2[j]){
                if(!tmap.containsKey(arr1[i])){
                    tmap.put(arr1[i],1);
                }
                i++;
            }
            else{
                if(!tmap.containsKey(arr2[j])){
                    tmap.put(arr2[j],1);
                }
                j++;
            }
        }
        while(i<n){
            if(!tmap.containsKey(arr1[i])){
                    tmap.put(arr1[i],1);
                }
                i++;
        }
        while(j<m){
            if(!tmap.containsKey(arr2[j])){
                tmap.put(arr2[j],1);
            }
            j++;
        }
        //now treemap se elements nikalke simply array list mei put krdo
        ArrayList<Integer> ans = new ArrayList<>();
        for(int num:tmap.keySet()){
            ans.add(num);
        }
        return ans;
    }
}
