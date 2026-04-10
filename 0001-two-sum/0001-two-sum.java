class Solution {
    public int[] twoSum(int[] nums, int target) {
        // have to return the indices so we cannot use sorting
        int n = nums.length;
        /*
        // Brute Force Approach - using two loops
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                int sum = nums[i]+nums[j];
                if(sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        */
        // Optimized Approach - using HashMap
        HashMap<Integer,Integer> hmap = new HashMap<>();
        // insert element value and index in hashmap
        for(int i=0;i<n;i++) {
            int complement = target - nums[i];
            if(hmap.containsKey(complement)) {
                return new int[]{hmap.get(complement), i};
            }
            hmap.put(nums[i], i);
        }
        return new int[]{}; 
    }
}