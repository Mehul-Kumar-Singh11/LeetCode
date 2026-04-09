class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = sumOfAllElements(nums);
        int max_sum = maxSubarraySum(nums);
        int min_sum = minSubarraySum(nums);
        // Edge case: when all elements are negative
        if(max_sum < 0) return max_sum;
        int res = Math.max(max_sum, (totalSum - min_sum));
        return res;
    }
    public int maxSubarraySum(int[] nums) {
        int bestEnding = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++) {
            bestEnding = Math.max(bestEnding+nums[i], nums[i]);
            res = Math.max(res, bestEnding);
        }
        return res;
    }
    public int minSubarraySum(int[] nums) {
        int bestEnding = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++) {
            bestEnding = Math.min(bestEnding+nums[i], nums[i]);
            res = Math.min(res, bestEnding);
        }
        return res;
    }
    public int sumOfAllElements(int[] nums) {
        int sum = nums[0];
        for(int i=1;i<nums.length;i++) {
            sum += nums[i];
        }       
        return sum;
    }
}