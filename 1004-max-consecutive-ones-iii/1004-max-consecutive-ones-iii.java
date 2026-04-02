class Solution {
    public int longestOnes(int[] nums, int k) {
        int low=0;
        int max_len=0;
        int ones_freq = 0;
        int n = nums.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int high=0;high<n;high++) {
            hmap.put(nums[high], hmap.getOrDefault(nums[high],0) + 1);
            if(nums[high]==1) { ones_freq++; }
            while((high - low + 1) - ones_freq > k) {
                hmap.put(nums[low], hmap.get(nums[low])-1);
                if(nums[low] == 1) { ones_freq--; }
                low++;
            }
            max_len = Math.max(max_len, high - low + 1);
        }
        return max_len;
    }
}