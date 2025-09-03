class Solution {
    public boolean isMatch(String s, String p) {
        return solve(0, 0, s, p);
    }

    public boolean solve(int i, int j, String s, String p) {
        // Base Case
        if(j == p.length()) {
            if(i == s.length()) {
                return true;
            }
            return false;
        }

        boolean first_char_matched = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if(j+1 < p.length() && p.charAt(j+1) == '*') {
            // not take
            boolean not_Take = solve(i, j+2, s, p);
            // take
            boolean take = first_char_matched && solve(i+1, j, s, p);

            return not_Take || take;
        }  
        return first_char_matched && solve(i+1, j+1, s, p);
    }
}