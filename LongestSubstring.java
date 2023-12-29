package LEETCODE;
import java.util.*;

public class LongestSubstring {
  // Find longest substring without repeating character
  // PBLM LINK : https://leetcode.com/problems/longest-substring-without-repeating-characters/
  // APPROACH
  // KEEP VISUALIZING AS YOU READ!!
  // we will keep two pointers --- left and right
  // And hum ek hashset create karenge jisme we will keep on storing the characters jisko right ptr point karte jaayega
  // phir hum check karenge ki jiss charcater ko right ptr point kar raha hai kya woh already present h kya hashmap mein if(TRUE) than left ptr se right tak travel karo and jo characters ko left is pointing keep on checking that, ki kya woh hashset mein hai and if yes than remove that charcater from the set
  // NOTE ---> Left ptr tab tak hi chalega jab tak left<=right and right ptr jis character ko point kar raha hai woh abhi bhi hashset mein present h
  // Keep on updatibg the length value and update maxLength value 
  // dono ptr will start from idx 0
  //  l
  // "p w w k e w"   --------- maxLength =0       hashset -()
  //  r
  //  l
  // "p w w k e w"   --------- maxLength =1       hashset -(p)
  //    r
  //  l
  // "p w w k e w"   --------- maxLength =2       hashset -(p,w)
  //      r
  //    l
  // "p w w k e w"   --------- maxLength =2       hashset -(w)   since new_len = r-l+1 = 2-1+1 = 2 jo ki maxLnegth se bada nhi hai, so it will not get updated
  //      r
  //      l
  // "p w w k e w"   --------- maxLength =2       hashset -()
  //      r
  //      l
  // "p w w k e w"   --------- maxLength =2       hashset -(w)
  //        r
  //      l
  // "p w w k e w"   --------- maxLength =3       hashset -(w,k)
  //          r
  //      l
  // "p w w k e w"   --------- maxLength =3       hashset -(w,k,e)
  //            r
  //      l
  // "p w w k e w"   --------- maxLength =3       hashset -(w,k,e)
  //            r
  //        l
  // "p w w k e m"   --------- maxLength =3       hashset -(k,e)
  //            r
  //  l
  // "p w w k e m"   --------- maxLength =3       hashset -(k,e,w)
  //               r

  // CODE
  public static int longestStringWORC(String str){
    int l = 0,r=0;
    int maxLength =0;
    HashSet<Character> hs = new HashSet<>();
    while(r<str.length()){
      char ch = str.charAt(r);
      if(hs.contains(ch)){
        while(l<=r && hs.contains(ch)){
          char ch1 = str.charAt(l);
          if(hs.contains(ch1)){
            hs.remove(ch1);
            l++;
          }
        }
        hs.add(ch);
        if(maxLength<r-l+1) maxLength = r-l+1;
      }else{
        hs.add(ch);
        if(maxLength<r-l+1) maxLength = r-l+1;
      }
      r++;
    }
    return maxLength;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the string : ");
    String s = sc.nextLine();
    int length = longestStringWORC(s);
    System.out.println("Longest length : "+length);
  }
}
