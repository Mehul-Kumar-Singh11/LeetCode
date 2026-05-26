class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n-1;
        int trapped_water = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            
            if(leftMax < rightMax) {
                trapped_water += leftMax - height[i];
                i++;
            }
            else{
                trapped_water += rightMax - height[j];
                j--;
            }
        }
        return trapped_water;
    }
}