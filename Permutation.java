package LEETCODE;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
  // 1--> Generating permutations for string "abc","ace",etc
/*
Recursive Tree
          ""       /        "abc"
        /             |        \
  "a"/"bc"         "b"/"ac"  "c"/"ab"
  /      \          /     \    /     \
"ab"/"c" "ac"/"b".........   "ca"/"b" "cb"/"a"
    |          |                |          |
  "abc"/""    "acb"/"" ...... "cab"/""   "cba"/""
 */
//CODE
public static void generatePermutation(String p,String up){
  if(up.isEmpty()){
    System.out.println(p);
    return;
  }
  for(int i=0;i<up.length();i++){
    char ch = up.charAt(i);
    String left = up.substring(0, i);
    String right = up.substring(i+1);
    String s = left + right;
    generatePermutation(p+ch, s);
  }
}

// returning it in a list
public static List<String> permutationList(String p,String up){
  if(up.isEmpty()){
    List<String> list = new ArrayList<>();
    list.add(p);
    return list;
  }
  List<String> ans = new ArrayList<>();
  for(int i=0;i<up.length();i++){
    char ch = up.charAt(i);
    String left = up.substring(0, i);
    String right = up.substring(i+1);
    String s = left + right;
    ans.addAll(permutationList(p+ch, s));
  }
  return ans;
}
  public static void main(String[] args) {
    generatePermutation("", "abc");
    List<String> pList = permutationList("", "abc");
    System.out.println(pList);
  }
}
