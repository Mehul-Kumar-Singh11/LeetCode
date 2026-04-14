class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        if(n == 0) {
            return ans;
        }
        if(n == 1) {
            int res = nums[0]*nums[0];
            ans[0] = res;
            return ans;
        }
        int i = 0;
        int j = n-1;
        int k = n-1;
        while(i<j) {
            int v1 = Math.abs(nums[i]);
            int v2 = Math.abs(nums[j]);
            if(v1 > v2) {
                ans[k] = v1 * v1;
                i++;
            }
            else{
                ans[k] = v2 * v2;
                j--;
            }
            k--;
        }
        ans[k] = nums[i]*nums[i];
        return ans;
    }
}