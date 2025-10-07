class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        mp.put(0, -1);

        int s = 0;
        Integer ml = 0; //max length

        for (int i = 0; i < nums.length; i++) {
            // Treat 0 as -1, 1 as +1
            s += (nums[i] == 0) ? -1 : 1;

            if (mp.containsKey(s)) {
                // If sum seen before, subarray between previous index and current  index has equal 0s and 1s ;

                ml = Math.max(ml, i - mp.get(s));
            } else {

                // Store first occurrence of this sum   
                mp.put(s, i);
            }
        }
        return ml;
    }
}