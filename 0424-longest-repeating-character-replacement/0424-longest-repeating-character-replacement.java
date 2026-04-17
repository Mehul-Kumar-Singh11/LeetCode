class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int max_len = Integer.MIN_VALUE;
        int[] a = new int[256];
        while (j < n) {
            // increment count of j index element
            a[s.charAt(j)] = a[s.charAt(j)] + 1;
            int max_count = calculate_max_count(a);
            int window_len = j - i + 1;
            int diff = window_len - max_count;
            while (diff > k) {
                // decrease window
                a[s.charAt(i)] = a[s.charAt(i)] - 1;
                i++;
                window_len = j - i + 1;
                max_count = calculate_max_count(a);
                diff = window_len - max_count;
            }
            int len = j - i + 1;
            max_len = Math.max(max_len, len);
            j++;
        }
        return max_len;
    }

    public int calculate_max_count(int[] a) {
        int max_count = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (max_count < a[i]) {
                max_count = a[i];
            }
        }
        return max_count;
    }
}