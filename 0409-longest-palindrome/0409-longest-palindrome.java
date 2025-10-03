class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                res = res + 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if (!set.isEmpty()) {
            res++;
        }
        return res;
    }
}