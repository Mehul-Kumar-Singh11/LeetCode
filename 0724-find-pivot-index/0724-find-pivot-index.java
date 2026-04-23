class Solution {
    public int pivotIndex(int[] a) {
        int n = a.length;
        // Brute Force Approach
        /*
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
        */
        // Optimized Approach
        int left_sum = 0;
        int right_sum = 0;
        int sum = calculate_sum(a, n);
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                left_sum = left_sum + a[i - 1];
            }
            right_sum = sum - a[i] - left_sum;
            if (left_sum == right_sum) {
                return i;
            }
        }
        return -1;
    }

    public int calculate_sum(int[] a, int n) {
        int sum = 0;
        for (int val : a) {
            sum += val;
        }
        return sum;
    }
}