class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int m = firstList.length;
        int n = secondList.length;
        while(i < m && j < n){
            int start1 = firstList[i][0];
            int end1 = firstList[i][1];
            int start2 = secondList[j][0];
            int end2 = secondList[j][1];
            // Step-1: Check which one started first
            if(start1 <= start2) {
                // check if intervals are over-lapping
                if(start2 <= end1) {
                    // find the intersection interval
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                     res.add(new int[]{s, e}); 
                }
            }
            else{
                // check if intervals are over-lapping
                if(end2 >= start1) {
                    // find the intersection interval
                    int s = Math.max(start1, start2);
                    int e = Math.min(end1, end2);
                    res.add(new int[]{s, e});
                }
            }
            if(end1 <= end2) {
                i++;
            }
            else{
                j++;
            }

        }
        return res.toArray(new int[res.size()][]);
    }
}