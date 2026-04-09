class Solution {
    public int maxAbsoluteSum(int[] nums) {
        if(nums.length == 1) {
            return Math.abs(nums[0]);
        }
        int minBestEnding = nums[0];
        int maxBestEnding = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++) {
            minBestEnding = Math.min(minBestEnding+nums[i], nums[i]);
            maxBestEnding = Math.max(maxBestEnding+nums[i], nums[i]);
            int maxAbsValue = Math.max(Math.abs(minBestEnding), Math.abs(maxBestEnding));
            res = Math.max(res, maxAbsValue);
        }
        return res;
    }
}