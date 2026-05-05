class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // first insert the new interval in the intervals array, then merge (remove overlap)
               // Step 1: Insert new interval in sorted order
        ArrayList<int[]> al = new ArrayList<>();
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!inserted && intervals[i][0] >= newInterval[0]) {
                al.add(newInterval);
                inserted = true;
            } 
                al.add(intervals[i]);
            }
        if(!inserted) {
            al.add(newInterval);
        }
                // Step 2: Merge intervals
        ArrayList<int[]> res = new ArrayList<>(); 
        int start = al.get(0)[0];
        int end = al.get(0)[1];
        for (int i = 1; i < al.size(); i++) {
            // check if it can be merged
            if (end >= al.get(i)[0]) {
                // calculate end
                end = Math.max(end, al.get(i)[1]);
            } else {
                // insert the current start end and update start end
                res.add(new int[] { start, end });
                start = al.get(i)[0];
                end = al.get(i)[1];
            }
        }
        res.add(new int[] { start, end });

        return res.toArray(new int[res.size()][]);
    }
}