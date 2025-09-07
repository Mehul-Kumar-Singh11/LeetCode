class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> curr = new LinkedList<Integer>();

        backtrack(nums, 0, new LinkedList<Integer>(), result);

        return result;
    }

    private void backtrack(int[] nums, int idx, LinkedList<Integer> curr, List<List<Integer>> result) {
        int n = nums.length;
        if (curr.size() > 1)
            result.add(new LinkedList<Integer>(curr));

        Set<Integer> used = new HashSet<>();

        for (int i = idx; i < n; i++) {

            if ((curr.size() == 0 || nums[i] >= curr.peekLast()) && !used.contains(nums[i])) {
                used.add(nums[i]);

                curr.add(nums[i]);

                backtrack(nums, i + 1, curr, result);

                curr.remove(curr.size() - 1);
            }
        }
    }
}