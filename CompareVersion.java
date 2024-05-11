//pblm link --> https://leetcode.com/problems/compare-version-numbers/description/?envType=daily-question&envId=2024-05-03
/*
BRUTE FORCE APPROACH --> har ek revision ki value ko ko calculate kro in both the versions and store kardo in two hashmaps
After that revision{index} ke basis pe just compare the revision values and find ki kaunsa version greater hai

v1 - "1.2", v2 - "1.10"
hmap1 - {0 - 1, 1 - 2}
hamp2 - {0 - 1, 1 - 10}
now simply hashmap ko traverse karke , key ke corresponding values ko compare krke u can identify the relationshil between version

agar dono map ka size equal hai toh just minimum length of hashmap tak hi loop chalana padega

but in below case
v1 - "1.0.1", v2 - "1"
hmap1 - {0 - 1, 1 - 0, 2 - 1}
hamp2 - {0 - 1}
minimum length out of two hashmap tak traverse krke hum ye nhi bata sakte hai ki kaunsa version greater hai

so jo dono mei se maximum length ka hai usko bhi traverse karke hume ye identify krna padega ki is it a greater version isiliye last mei phir se ek loop chalaya hai 
from {len to maxLen}

*/
class Solution {
    public int compareVersion(String version1, String version2) {
        //ek map create krta hoon and har ek revision ko store krta hoon with key as Revision and value as Numeric value
        //int i=0;
        HashMap<Integer,Integer> hmap1 = new HashMap<>();
        HashMap<Integer,Integer> hmap2 = new HashMap<>();
        int num = 0;
        int idx=0;
        for(int i=0;i<version1.length();i++){
            if(version1.charAt(i)=='.'){
                hmap1.put(idx,num);
                idx++;
                num=0;
            }
            else{
                char ch = version1.charAt(i);
                num = num*10+(ch-'0');
            }
        }
        hmap1.put(idx,num);//last revsision pe jo number hai usko bhi add krdo in map1
        num = 0;
        idx=0;
        for(int i=0;i<version2.length();i++){
            if(version2.charAt(i)=='.'){
                hmap2.put(idx,num);
                idx++;
                num=0;
            }
            else{
                char ch = version2.charAt(i);
                num = num*10+(ch-'0');
            }
        }
        hmap2.put(idx,num);//last revsision pe jo number hai usko bhi add krdo in map2
        int len = Math.min(hmap1.size(),hmap2.size());
        for(int i=0;i<len;i++){
            int v1 = hmap1.get(i);
            int v2 = hmap2.get(i);
            if(v1<v2){
                return -1;
            }
            else if(v1>v2){
                return 1;
            }
        }
        //now dono mei se jo bada map tha uske remaining remaining elements ko check karo, agar kahi pe bhi revision ki value > 0 aati hai that means ki woh version greater hai
        int maxLen = Math.max(hmap1.size(),hmap2.size());
        for(int i=len;i<maxLen;i++){
            if(i<hmap1.size() && hmap1.get(i)>0){
                return 1;
            }
            if(i<hmap2.size() && hmap2.get(i)>0){
                return -1;
            }
        }
        return 0;
    }
}
