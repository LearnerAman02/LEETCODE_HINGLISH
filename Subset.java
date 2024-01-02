package LEETCODE;
import java.util.*;
public class Subset {
  // PBLM LINK : https://leetcode.com/problems/subsets/description/
  // we have two approaches to generate subsets
  // 1 ---> Iterative Approach
/*
APPROACH
ITERATIVE FLOW
          [[]]
        /     \
      [[]     ,[1]]   
      /          \
    [[],[1],     [2],[1,2]]
      /             \
[[],[1],[2],[1,2]    [3],[1,3],[2,3],[1,2,3]]
Ek empty list create kro and than upar wale level ke list ko as it is copy kro and than usme array ke element ko add kro
 */
// CODE

public static List<List<Integer>> genSubsetList(int [] nums){
  List<List<Integer>> outer = new ArrayList<>();
  outer.add(new ArrayList<>());
  for(int num : nums){
    int n = outer.size();
    for(int i=0;i<n;i++){
      // outer ko as it rakho and uske har ek list pe iterate karo and uss list mein than just add array nums ka element
      List<Integer> internal = new ArrayList<>(outer.get(i));
      internal.add(num);
      outer.add(internal);
    }
  }
  return outer; 
}

  // 2 ---> Recursion and BackTracking 
/*
APPROACH
so will run a for loop to iterate over each element in the array and than recursive call will be made inside each iteration
So note this -->
jab i=0 ---> toh iske liye recursive call lagegi further for index (1,2,3)
jab i=1 ---> toh iske liye recursive call lagegi further for index (2,3)
jab i=2 ---> toh iske liye recursive call lagegi further for index (3)
come out from the for loop and no further recursive calls

BACKTRACKING karte waqt we will keep on removing the last element in the current list and than jo remaining numbers hai that will get added into the current list for new set of subset

                       (0,nums,[],res)
                       /         |     \
                    i=0          i=1   i=2 ------- level 1
                res =[[]]
                curr=[1]
          (1,nums,[1],[[]])
           |
          res = [[],[1]]
          curr=[1,2]
          (2,nums,[1,2],[[],[1]])---
            |                       | 
        res =[[],[1],[1,2]]         |curr=[1] ---{BACTRACKING} and iske backtracking ke time i=2 call hoga because i<3 and waha se [1,3] will get added into the res list
          curr=[1,2,3]      --------     
          (3,nums,[1,2,3],[[],[1],[1,2]])
             |
          res = [[],[1],[1,2],[1,2,3]]
          (loop ke bahar aa jaayega)

          Same way recursive call will goanna be executed for i=1 and i=2 at level 1 and final subset will be generated

          FLOW OF GENERATION OF CURRENT LIST which will be added in RES LIST
               [   ]
              /  \   \
            [1]   [2] [3]
            /  \     \
        [1,2] [1,3]  [2,3]
          /
        [1,2,3]
*/
public static void generateSubset(int index,int [] arr,List<Integer> curr,List<List<Integer>> res){
  res.add(new ArrayList(curr));
  for(int i=index;i<arr.length;i++){
    curr.add(arr[i]);
    generateSubset(i+1, arr, curr, res);
    curr.remove(curr.size()-1);// during BACKTRACKING
  }
  //System.out.println(res);
}
  public static void main(String[] args) {
    int [] nums = {1,2,3};
    List<List<Integer>> res = new ArrayList();
    generateSubset(0, nums, new ArrayList(), res);
    System.out.println(res);
    List<List<Integer>> subsetList = genSubsetList(nums);
    System.out.println(subsetList);
  }
}

// SUBSET - II
// PBLM LINK : https://leetcode.com/problems/subsets-ii/description/
// same approach just outer list mein add krne se pehle check karo and array ko sort krlo 
