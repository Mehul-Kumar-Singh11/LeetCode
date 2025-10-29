class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, res = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                if (k != 0)
                    k--;
                else {
                    while (left < right && nums[left] != 0)
                        left++;
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}