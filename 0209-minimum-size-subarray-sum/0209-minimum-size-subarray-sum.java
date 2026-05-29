class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        int currSum = 0;
        while(j<nums.length) {
            currSum += nums[j];
            while(currSum >= target) {
                int len = j - i + 1;
                minLen = Math.min(len, minLen);
                currSum -= nums[i];
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}