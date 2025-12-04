class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int k = 0;
        int j = 1;
        int n = nums.length;
        while (j < n) {
            if (nums[j] == nums[k] && k == i) {
                k++;
                nums[k] = nums[j];
            } else if (nums[j] != nums[k]) {
                k++;
                nums[k] = nums[j];
                i = k;
            }
            j++;
        }
        return k + 1;
    }
}