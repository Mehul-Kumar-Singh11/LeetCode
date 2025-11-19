class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (hmap.containsKey(complement)) {
                return new int[] { i, hmap.get(complement) };
            }
            hmap.put(nums[i], i);
        }
        return new int[] {};
    }
}