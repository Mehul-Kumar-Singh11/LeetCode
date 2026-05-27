class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min_size = Integer.MAX_VALUE;
        int low = 0;
        int high = 0;
        int curr_sum = 0;
        while(high<n) {
            curr_sum += nums[high];
            while(curr_sum >= target) {
                int curr_size = high - low + 1;
                min_size = Math.min(min_size, curr_size);
                curr_sum -= nums[low];
                low++;
            }
            high++;
        }
        return min_size == Integer.MAX_VALUE ? 0 : min_size;
    }
}