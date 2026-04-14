class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int target = 0;
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++) {
            if(i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = n-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // skip duplicates  for j and k
                    while(j<k && nums[j]==nums[j-1]) { j++; }
                    while(j<k && nums[k]==nums[k+1]) { k--; }
                }
                else if(sum < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return list;
    }
}