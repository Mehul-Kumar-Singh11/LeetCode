class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void solve(int[] nums, int i, List<Integer> temp, List<List<Integer>> result) {
        if(i >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Take nums[i] in temp list
        temp.add(nums[i]);
        solve(nums, i+1, temp, result);
        
        // Don't take nums[i] in temp list
        temp.remove(temp.size()-1);
        solve(nums, i+1, temp, result);
    }
}