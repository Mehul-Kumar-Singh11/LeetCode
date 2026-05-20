class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int k = n - 1;
        int[] res = new int[n];
        while (i < j) {
            int v1 = Math.abs(nums[i]);
            int v2 = Math.abs(nums[j]);
            if (v1 > v2) {
                res[k] = v1 * v1;
                i++;
            } else {
                res[k] = v2 * v2;
                j--;
            }
            k--;
        }
        res[k] = nums[i] * nums[i];
        return res;
    }
}