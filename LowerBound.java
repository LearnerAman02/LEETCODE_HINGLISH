// pblm link --> https://www.codingninjas.com/studio/problems/lower-bound_8165382?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM&count=25&page=1&search=&sort_entity=order&sort_order=ASC
// Approach --> we know to perform BINARY SEARCH 
// bas simple updation hume ye sochna hai ki agar mid pe aane wali value is greater than my target value than uss case mein 
// I have got one expected answer and now search for the idx which cotains value equal to target or the value lesser than the expected value but greate than the target value
public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        int s=0;
        int e=n-1;
        int ans=-1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(arr[m]>=x){
                // means value greater than or equal to x mil chuki hai and it is one of the possible answer 
                ans = m;
                e = m-1;// and now search for the first occurence of lower bound
            }else{
                s=m+1;
            }
        }
        // now if ans=-1 hi raha means hume koi lower bound value nhi mili than we have to return the length of array as it is 
        return ans==-1 ? n:ans;
    }
}
