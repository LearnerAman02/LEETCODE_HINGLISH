//BRUTE FORCE APPROACH --> TLE
class Solution {
    public String replaceWords(List<String> dictionary, String s) {
        TreeMap<Integer,String> tmap = new TreeMap<>();
    //list.add("c");
    //String s = "the abcd are crow hidden";
    String fans = "";
    int n = s.length();
    int c = 0;
    int midx = 0;
    int idx = 0;
    for(int i=0;i<n;i++){
      
      //substring nikalo and isko check karo ki kya woh list mei present hai kya 
      String sub = s.substring(c,i);
      //System.out.println("substring : "+sub);
      if(dictionary.contains(sub)){
        //System.out.println("match substring : "+sub);
        while(i<n && s.charAt(i)!=' '){
         i++;
        }
        tmap.put(midx,sub);
        midx++;
        c = i+1;
      }
      else if((i<n && s.charAt(i)==' ')){
        tmap.put(midx,sub);
        midx++;
        c = i+1;
      }
      else if(i==n){
        idx = i;
        break;
      }
      //sub = "";
    }
    if(c<n && idx<n){
        String f = s.substring(c,n);
        tmap.put(midx,f);
    }
    String ans = "";
    for(Integer a : tmap.keySet()){
        ans += tmap.get(a);
        ans += " ";
    }
    int b = ans.length();
    String fstr = ans.substring(0,b-1);
    return fstr;
    }
}

//APPROACH 2 --> ACCEPTED
class Solution {
    public String findRoot(Set<String> st,String word){
        for(int l=1;l<=word.length();l++){
            String sub = word.substring(0,l);
            if(st.contains(sub)){
                return sub;
            }
        }
        return word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> st = new HashSet<>(dictionary);
        StringBuilder res = new StringBuilder();
        String[] words = sentence.split(" ");
        for(String word : words){
            res.append(findRoot(st,word)).append(" ");
        }

        return res.toString().trim();
    }
}
