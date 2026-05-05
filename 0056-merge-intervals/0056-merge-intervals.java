class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> al = new ArrayList<>();
        // Sort based on starting time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0]<=end) {
                // can be merged
                end = Math.max(end, intervals[i][1]);
            }
            else{
                // add existing start,end and update start, end
                al.add(new int[]{start, end});
                // update start and end
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // add last interval
        al.add(new int[]{start,end});
        // convert arraylist to int[][]
        int[][] ans = al.toArray(new int[al.size()][]);
        return ans;
    }
}