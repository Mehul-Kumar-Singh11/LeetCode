class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int sum = 0;
        int count = 0;
        hmap.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int rem = sum % k;
            if(rem < 0) {
                rem = rem + k;
            }
            if(hmap.containsKey(rem)) {
                count += hmap.get(rem);
            }
            hmap.put(rem, hmap.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}