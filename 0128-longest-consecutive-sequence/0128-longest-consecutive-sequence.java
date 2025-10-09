class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        int max_length = 0;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        for(int num : set) {
            if(!set.contains(num-1)) {
                int curr_num = num;
                int curr_len = 1;

                while(set.contains(curr_num + 1)) {
                    curr_len++;
                    curr_num++;
                }

                max_length = Math.max(max_length, curr_len);
            }
        }
        return max_length;
    }
}
/*
        Arrays.sort(nums);

        int res = 1, cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            // Skip duplicates
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                cnt++;
            }
            else {
                cnt = 1;
            }

            res = Math.max(res, cnt);
        }
        return res;
    }
    */