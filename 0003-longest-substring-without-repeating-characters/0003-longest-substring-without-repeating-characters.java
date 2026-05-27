class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int low = 0;
        int high = 0;
        int maxLength = 0;
        HashMap<Character,Integer> hmap = new HashMap<>();
        while(high < n) {
            hmap.put(s.charAt(high), hmap.getOrDefault(s.charAt(high), 0) +1);
            while(hmap.get(s.charAt(high)) > 1) {
                hmap.put(s.charAt(low), hmap.get(s.charAt(low))-1);
                low++;
            }
            maxLength = Math.max(maxLength, high - low + 1);
            high++;
        }
        return maxLength;
    }
}