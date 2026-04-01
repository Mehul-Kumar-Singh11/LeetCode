class Solution {
    public int characterReplacement(String s, int k) {
        int max_len = 0;
        int low = 0;
        int max_freq = 0;
        int n = s.length();
        int[] freq = new int[26];
        for(int high=0;high<n;high++) {
            int index = s.charAt(high) - 'A';
            freq[index]++;
            max_freq = Math.max(max_freq, freq[index]);
            int len = high - low + 1;
            while(len - max_freq > k) {
                freq[s.charAt(low) - 'A']--;
                low++;
                len = high - low + 1;
            }
            max_len = Math.max(max_len, len);
        }
        return max_len;
    }
}