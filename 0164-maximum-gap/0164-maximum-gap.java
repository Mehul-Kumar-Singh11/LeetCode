class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max_num=0;
        if(nums.length<2) return 0;
        for(int i=0;i<nums.length-1;i++){
            int m = nums[i+1]-nums[i];
            max_num=Math.max(max_num,m);
        }
        return max_num;
    }
}