class Solution {
    public int maxArea(int[] height) {
        // Note: Here, we have to find the max area, take 2 pointers at both ends, calculate area i.e l * b, here length = min(v1, v2), breadth = j-i we are moving either i or j pointer based on which one has lower height, since j has already bigger height, moving i means we are looking for more height later.
        int n = height.length;
        int max_area = 0;
        int curr_area = 0;
        int i = 0 ;
        int j = n-1;

        while(i<j){
            int length = j - i;
            int breadth = Math.min(height[i], height[j]);
            curr_area = length * breadth;
            max_area = Math.max(max_area, curr_area);
            // now move the pointer (either i or j)-> resulting in decrease of width so we will be looking for more height to get more area
            if(height[i] < height[j]) {
                i++;
            }
            else {
                j--;
            }
        }
        return max_area;
    }
}