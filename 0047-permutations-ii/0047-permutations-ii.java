class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // sort to handle duplicates
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> result) {
        int n = nums.length;
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            // already used this element
            if (used[i]) {
                continue;
            }

            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }

            temp.add(nums[i]);
            used[i] = true;
            backtrack(nums, temp, used, result);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}