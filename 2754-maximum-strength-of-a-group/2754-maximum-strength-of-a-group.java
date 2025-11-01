class Solution {
    public long maxStrength(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int minus = -10;
        int count = 0;
        int countZero = 0;
        long ans = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
                continue;
            }
            ans *= nums[i];
            if (nums[i] < 0) {
                count++;
                minus = Math.max(minus, nums[i]);
            }
        }
        if (count % 2 != 0)
            ans /= minus;
        if ((count == 1 && countZero + 1 == nums.length) || countZero == nums.length)
            ans = 0;
        return ans;
    }
}