class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int prevWithDeleted = 0;
        int prevNotDeleted = nums[0];
        int finalMax = nums[0];
        
        for (int i = 1; i < n; i++) {
            prevWithDeleted = Math.max(prevNotDeleted, prevWithDeleted + nums[i]);
            prevNotDeleted = Math.max(prevNotDeleted + nums[i], nums[i]);
            int currMax = Math.max(prevNotDeleted, prevWithDeleted);
            finalMax = Math.max(finalMax, currMax);
        }
        return finalMax;
    }
}