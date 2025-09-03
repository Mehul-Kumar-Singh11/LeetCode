class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s, p);
    }

    public boolean solve(String s, String p) {
        // Base Case
        if(p.length() == 0 ) {
            if(s.length() == 0) {
                return true;
            }
            return false;
        }

        boolean first_char_matched = (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if(p.length() >= 2 && p.charAt(1) == '*') {
            // not take
            boolean not_Take = solve(s, p.substring(2));
            // take
            boolean take = first_char_matched && solve(s.substring(1), p);

            return not_Take || take;
        }  
        return first_char_matched && solve(s.substring(1), p.substring(1));
    }
}