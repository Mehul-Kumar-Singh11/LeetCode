class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }
        int[] prefix = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < prefix.length; i++) {
            prefix[i] = prefix[i] % k;
            if (map.containsKey(prefix[i])) {
                if (i - map.get(prefix[i]) >= 2)
                    return true;
            } else {
                map.put(prefix[i], i);
            }
        }
        return false;
    }
}