 //pblm link --> https://www.naukri.com/code360/problems/find-two-missing-numbers_1214700?topList=oracle-interview-questions&problemListRedirection=true&count=25&page=1&search=&sort_entity=order&sort_order=ASC&leftPanelTabValue=SUBMISSION&customSource=studio_nav
import java.util.* ;
import java.io.*; 
public class Solution {
	public static ArrayList<Integer> findMissingNumbers(ArrayList<Integer> arr, int n) {
		ArrayList<Integer> ans = new ArrayList<>();
		//ye hai BRUTE FORCE approach 
		//1 se lekar n tak ka loop chalao and check kro ki kya woh number list mei present hai yaa nhi
		int curr = arr.get(0);
		for(int i=1;i<=n;i++){
			if(!arr.contains(i)){
				ans.add(i);
			}
		}
		return ans;
	}
}

//T.C. --> O(N*M)
// N times bahar wala loop chalega and M times andar wala chalega for iterating over each element internally
//S.C. -->O(1)
