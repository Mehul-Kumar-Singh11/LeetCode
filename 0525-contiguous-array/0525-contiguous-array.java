class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int res = 0;
        int zeros = 0, ones = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                ones++;
            }
            int diff = zeros - ones;
            if (diff == 0) {
                res = Math.max(res, i + 1);
            } else {
                // check if the diff already present in hashmap
                if (hmap.containsKey(diff)) {
                    int len = i - hmap.get(diff);
                    res = Math.max(res, len);
                } else {
                    // if doesn't exist in hashmap, insert in hashmap
                    hmap.put(diff, i);
                }
            }
        }
        return res;
    }
}