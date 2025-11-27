class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            int endCount = n - i;
            int startCount = i + 1;

            int totalSubarrays = startCount * endCount;

            int oddSubarrays = totalSubarrays / 2;
            if (totalSubarrays % 2 == 1)
                oddSubarrays++;

            totalSum += arr[i] * oddSubarrays;
        }

        return totalSum;
    }
}