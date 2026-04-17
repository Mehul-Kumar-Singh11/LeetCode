class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int max_len = Integer.MIN_VALUE;
        int n = nums.length;
        int count_ones = 0;
        while (j < n) {
            if (nums[j] == 1) {
                count_ones++;
            }
            int window_len = j - i + 1;
            int diff = window_len - count_ones;
            // checking if difference is greater than threshold replacement
            while (diff > k) {
                // decrease count of element at i
                if (nums[i] == 1) {
                    count_ones--;
                }
                i++;
                window_len = j - i + 1;
                diff = window_len - count_ones;
            }
            int len = j - i + 1;
            max_len = Math.max(max_len, len);
            j++;
        }
        return max_len;
    }
}