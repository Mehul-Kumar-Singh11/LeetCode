class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0, new ArrayList<>());
        return result;
    }

    public void solve(int[] nums, int i, List<Integer> temp) {
        if(i >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Take nums[i] in temp list
        temp.add(nums[i]);
        solve(nums, i+1, temp);
        
        // Don't take nums[i] in temp list
        temp.remove(temp.size()-1);
        solve(nums, i+1, temp);
    }
}