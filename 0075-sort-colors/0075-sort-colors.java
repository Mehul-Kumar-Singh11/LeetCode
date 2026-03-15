class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int start=0, mid=0, end=n-1;
        while(mid<=end) {
            if(nums[mid] == 2) {
                swap(nums, mid, end);
                end--;
            }
            else if(nums[mid] == 1) {
                mid++;
            } 
            else{
                swap(nums, start, mid);
                start++;
                mid++;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}