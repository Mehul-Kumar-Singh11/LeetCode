class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        // detect cycle
       while(true) {  // true because we know cycle exists  
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                break;
            }
       }
       // find starting point
       slow = nums[0];
       while(slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
       }
       return slow;
    }
}