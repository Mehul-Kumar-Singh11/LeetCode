class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        // Stack Formation
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }
        int maxWidth = 0;
        // Traverse the array backwards
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }
        return maxWidth;
    }
}