class Solution {
    public int dominantIndex(int[] nums) {
        int largest = -1;
        int index = -1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]>largest){
            largest = nums[i];
            index = i;
            }
        }
        for(int j = 0; j<nums.length; j++){
            if(j != index && (largest < 2*nums[j])){
                return -1;
            }
        }
        return index; 
    }
}