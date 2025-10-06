class Solution {
    public int maxArea(int[] height) {
        int maxWaterStored = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            int width = j - i;
            int area = minHeight * width;
            System.out.println("Area-> " + area);
            maxWaterStored = Math.max(maxWaterStored, area);
            // Move index which has lesser value, in hope of getting bigger value next time
            // as greater the height more water can be contained
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxWaterStored;
    }
}