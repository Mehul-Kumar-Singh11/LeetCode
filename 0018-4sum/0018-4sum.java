class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> al = new ArrayList<>();
        int[] tempNums = Arrays.copyOf(nums, n);
        Arrays.sort(tempNums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && tempNums[i] == tempNums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && tempNums[j] == tempNums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = (long)tempNums[i] + tempNums[j] + tempNums[k] + tempNums[l];
                    if (sum == target) {
                        al.add(Arrays.asList(tempNums[i], tempNums[j], tempNums[k], tempNums[l]));
                        k++;
                        l--;
                        while (k < l && tempNums[k] == tempNums[k - 1]) {
                            k++;
                        }
                        while (k < l && tempNums[l] == tempNums[l + 1]) {
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return al;
    }
}