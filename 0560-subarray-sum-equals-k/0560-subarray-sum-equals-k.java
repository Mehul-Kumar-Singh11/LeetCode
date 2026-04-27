class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            int remaining = sum - k;
            // check if remaining is present in hashmap
            if(hmap.containsKey(remaining)) {
                count += hmap.get(remaining);
            }
            // insert in hashmap
            hmap.put(sum, hmap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}