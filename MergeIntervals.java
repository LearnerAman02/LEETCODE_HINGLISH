r = row x column
iska time complecxity O(r logr) hai aur space complexity O(r) hai
class Solution {
    public int[][] merge(int[][] intervals) {
        //ek comparator likh rha hoon JAVA mei jiske help se main simply given array ko SORT kr rha hoon
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int b[]){
                if(a[0]==b[0]){
                    return Integer.compare(a[1],b[1]);
                }
                else{
                    return Integer.compare(a[0],b[0]);
                }
            }
        });
        int r = intervals.length;
        //now s hai start value of the interval
        //and e hai end value of the interval
        //simply ab mai first given interval ko start and end interval maan rha hoon and initialize kara rha hoon
        int s = intervals[0][0];
        int e = intervals[0][1];
        int i=0;
        //ek List of List create kri hai jo final merged intervals ke list ko contain krega
        List<List<Integer>> ans = new ArrayList<>();
        //now we are iterating over each given interval for merging the interval 
        while(i<intervals.length-1){
            List<Integer> l = new ArrayList<>();
            if(e>=intervals[i+1][0]){
                //overlapping tab hoga jab current interval ka last value >= next interval ka start value 
                //overlapping tha isiliye humne update kr diya hai cheezon ko
                //update krdo end ki value ko because interval merge hue hai
                e = Math.max(intervals[i+1][1],e);
            }
            else{
                //now current interval merge nhi ho rha hai next aane wale interval se
                //so iska matlab ye hai ki hume current index tak ka overlapped interval mil chuka hai
                //usko list mei add krdo and start and end ko update krdo
                l.add(0,s);
                l.add(1,e);
                ans.add(new ArrayList(l));
                s = intervals[i+1][0];
                e = intervals[i+1][1];
            }
            i++;
        }
        List<Integer> l = new ArrayList<>();
        if(e>=intervals[r-1][0]){
            //overlapping tha isiliye humne update kr diya hai cheezon ko for last interval in the given interval array
            e = Math.max(e,intervals[r-1][1]);
        }
        l.add(0,s);
        l.add(1,e);
        ans.add(new ArrayList(l));
        int m = ans.size();
        int n = 2;
        int[][] matrix = new int[m][n];
        //ab arraylist ko traverse krke final matrix banado
        for(int p=0;p<m;p++){
            for(int q=0;q<n;q++){
                List<Integer> row = ans.get(p);
                matrix[p][q] = row.get(q);
            }
        }
        return matrix;
    }
}
