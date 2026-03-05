class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int i = 0, j = 1;
        while (j < n) {
            if (nums[j] != nums[j - 1]) {
                nums[i + 1] = nums[j];
                i++;
            }
            j++;
        }
        // while (j < n) {
        //     if (nums[i] != nums[j]) {
        //         i++;
        //         nums[i] = nums[j];
        //     }
        //     j++;
        // }
        return i + 1;
    }
}