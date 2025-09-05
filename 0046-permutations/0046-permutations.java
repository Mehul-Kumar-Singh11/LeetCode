class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // backtrack(nums, new ArrayList<>(), new boolean[nums.length], result);
        swapping(nums, 0, result);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> temp, boolean[] used, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(nums[i]);

                backtrack(nums, temp, used, result);

                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

    public void swapping(int[] nums, int idx, List<List<Integer>> result) {
        if (idx >= nums.length) {
            List<Integer> temp = new ArrayList<>(nums.length);
            for (int num : nums) {
                temp.add(num);
            }
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx); // Do
            swapping(nums, idx + 1, result); // Explore
            swap(nums, i, idx); // Undo
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}