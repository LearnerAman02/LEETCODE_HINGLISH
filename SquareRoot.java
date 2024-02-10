// pblm link --> https://www.codingninjas.com/studio/problems/square-root-integral_893351?leftPanelTab=0%3Futm_source%3Dstriver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
import java.util.* ;
import java.io.*; 
// Optimal Code using BINARY SEARCH 
// Q. Find square root of N
// N = 37
// search space [1......19.......37] -- Note ye array nhi hai we are using possible values ka range for applying binary search on it
//               s      m         e
// since 19*19 > 37 --- means hamara answer 19 ke behind wale region mein lie karega i.e. [1........19] so e=m-1
// search space [1....10....19] -- Note ye array nhi hai we are using possible values ka range for applying binary search on it
//               s     m     e
// since 10*10 > 37 --- means hamara answer 19 ke behind wale region mein lie karega i.e. [1........19] so e=m-1
// search space [1....5.....10] -- Note ye array nhi hai we are using possible values ka range for applying binary search on it
//               s    m      e
//  since 5*5 < 37 iska matlab ye hai ki 5 ek possible floor value hai and sice aage isse bigger value can occur so now we have to search in right portion so s=m+1
// search space [5....7....10] -- Note ye array nhi hai we are using possible values ka range for applying binary search on it
//               s    m     e
// since 7*7 > 37 means floor value cannot be this and hamara answer 7 ke behind wale region mein lie karega i.e. [5..6] so e=m-1
// search space [5,6] -- Note ye array nhi hai we are using possible values ka range for applying binary search on it
//               s e
//               m
// since 5*5 < 37 iska matlab ye hai ki 5 ek possible floor value hai and sice aage isse bigger value can occur so now we have to search in right portion so s=m+1
// search space [6] -- Note ye array nhi hai we are using possible values ka range for applying binary search on it
//               s 
//               e
//               m
// since 6*6 < 37 iska matlab ye ek possible floor value hai and further possible values will be on right side so s=m+1
// search space [6] -- Note ye array nhi hai we are using possible values ka range for applying binary search on it
//               e s
// since s>e it is BREAKING CONDITION for the while loop and NOTE --> YAHA HAMARA FINAL ANSWER IS OCCURING ON idx e
public class Solution {
	public static int sqrtN(long N) {
		long s=1;
		long e=N;
		long ans =1;
		while(s<=e){
			long m = s+(e-s)/2;
			if(m*m<=N){
				ans = m;
				// now remaining aage ke part mein search karo, RIGHT HALF
				s=m+1;
			}else{
				// value is greater than search if left half
				e = m-1;
			}
		}
		ans = e;// high at the end hamare answer ko store karega
		return (int)ans;
	}
}
