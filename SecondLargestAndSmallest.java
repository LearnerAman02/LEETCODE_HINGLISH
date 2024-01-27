// Pblm link --> https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960?utm_source=striver&utm_medium=website&utm_campaign=codestudio_a_zcourse&leftPanelTabValue=PROBLEM
// logic --> pehle traverse karke just nikal lo first max and first mun value ka position and than substitute their -1
// after that just traverse the array and check the next greater and smaller elements 
public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        int maxIdx = -1;
        int minIdx=-1;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++){
            if(max<a[i]){
                maxIdx=i;
                max = a[i];
            }
            if(min>a[i]){
                minIdx=i;
                min = a[i];
            }
        }
        //System.out.println("Max element idx :"+maxIdx);
        //System.out.println("Min element idx :"+minIdx);
        a[maxIdx]=-1;
        a[minIdx]=-1;
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(max<a[i] && a[i]!=-1){
                maxIdx=i;
                max = a[i];
            }
            if(min>a[i] && a[i]!=-1){
                minIdx=i;
                min = a[i];
            }
        }
        int ans[] = new int[2];
        ans[0]=max;
        ans[1]=min;
        return ans;
    }
}
