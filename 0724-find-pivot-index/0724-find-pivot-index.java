class Solution {
    public int pivotIndex(int[] a) {
        int n = a.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 0;
        for(int i=1;i<n;i++) {
            prefix[i] = prefix[i-1] + a[i-1];
        }
        suffix[n-1] = 0;
        for(int j=n-2;j>=0;j--) {
            suffix[j] = suffix[j+1] + a[j+1];
        }

        for(int z=0;z<n;z++){
            if(prefix[z] == suffix[z]) {
                return z;
            }
        }
        return -1;
    }
}