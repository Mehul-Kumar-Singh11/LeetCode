class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int min_diff = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++) {
            int j = i+1;
            int k = n-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);
                if(diff < min_diff) {
                    min_diff = diff;
                    ans = sum;
                }
                if(sum == target) {
                    return sum;
                }
                else if (sum < target) {
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        return ans;
    }
}