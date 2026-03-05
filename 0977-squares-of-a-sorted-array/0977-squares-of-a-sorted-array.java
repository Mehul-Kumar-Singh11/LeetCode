class Solution {
    public int[] sortedSquares(int[] nums) {
        // either extreme left or right will have the max value
        int n = nums.length;
        int i=0,j=n-1, pos=n-1;
        int[] res = new int[n];
        while(i<=j) {
            if(Math.abs(nums[i]) < Math.abs(nums[j])) {
                res[pos] = nums[j]*nums[j];   
                j--;
            }
            else {
                res[pos] = nums[i]*nums[i];
                i++;
            }
            pos--;
        }
        return res;
    }
}