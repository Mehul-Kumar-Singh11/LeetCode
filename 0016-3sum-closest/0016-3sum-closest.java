class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int min_diff = Integer.MAX_VALUE;
        int closest_sum = 0;
        for(int i=0;i<n-2;i++) {
            int j = i+1;
            int k = n-1;
            while(j  < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // calculate min_diff and closest_sum
                int diff = Math.abs(sum - target);

                if(min_diff > diff) {
                    min_diff = diff;
                    closest_sum = sum;
                }

                if(sum == target) {
                    return sum;
                }
                else if(sum > target) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return closest_sum;
    }
}