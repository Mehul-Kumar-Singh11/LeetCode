class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len = 1, l = 0, sign = -1;
        for (int r = 1; r < arr.length; r++) {
            if (arr[r - 1] > arr[r] && sign != 0)
                sign = 0;
            else if (arr[r] > arr[r - 1] && sign != 1)
                sign = 1;
            else if (arr[r] == arr[r - 1])
                l = r;
            else {
                l = r - 1;
                sign = arr[r - 1] > arr[r] ? 0 : 1;
            }
            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}