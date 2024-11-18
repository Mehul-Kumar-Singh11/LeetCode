/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    // using two loops
    /* for(let i=0;i<nums.length-1;i++) {
      for(let j=i+1;j<nums.length;j++) {
         if(nums[i]+nums[j]==target){
            return new Array(i,j);
         }
      }
    } */
    // using map
    const map = new Map();
     for(let i=0;i<nums.length;i++){
        let rem_value = target - nums[i]; 
        // first check whether remaining value is present in the hmap
        if(map.has(rem_value)) {
            let rem_value_index = map.get(rem_value)
            return new Array(rem_value_index,i)
        }
        else{
            map.set(nums[i], i)
        }
    }
};