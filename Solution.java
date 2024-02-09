import java.util.* ;
import java.io.*; 
// BRUTE FORCE Approach --> I am using inbuilt Math.sqrt(num) function 
// NOTE --> num - dataType will be double and this function returns double type of value
// so at last typecast to required data type
public class Solution {

	public static int sqrtN(long N) {
		int ans = (int)Math.sqrt(N);
		return ans;
	}
}
