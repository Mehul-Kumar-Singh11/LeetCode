class Solution {
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            int l = 0;
            int r = s.length() - 1;
            
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                l++;
                r--;
            }
            if (l >= r) {
                return s;
            }
        }
        return "";
    }
}