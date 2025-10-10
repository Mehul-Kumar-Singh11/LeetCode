class Solution {
    public boolean canJump(int[] nums) {
        // Initially the final position is the last index
        int finalPosition = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            // If you reach the final position from this index then
            // update the final position index
            if (i + nums[i] >= finalPosition) {
                finalPosition = i;
            }
        }

        // If we reach the first index, then the jump is possible
        return finalPosition == 0;
    }
}