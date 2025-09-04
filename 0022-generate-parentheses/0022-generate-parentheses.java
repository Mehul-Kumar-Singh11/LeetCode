class Solution {
    List<String> result = new ArrayList<>();
    // Not Efficient Approach, gives Memory Limit Exceeded -> n=3
    /* 
    public List<String> generateParenthesis(int n) {
        solve("", n);
        return result; 
    }
    
    public void solve(String s, int n) {
        if(s.length() == 2*n) {
            if(isValidParentheses(s)) {
                result.add(s);
            } 
            return;
        }
    
        s += '(';
        solve(s, n);
        s = s.substring(0, s.length()-1);
    
        s += ')';
        solve(s, n);
        s = s.substring(0, s.length()-1);
    }
    
    public boolean isValidParentheses(String str) {
        int count = 0;
        for(char ch : str.toCharArray()) {
            if(ch  == '(') {
                count++;
            }
            else { 
                count--;
            }
            // check for string "())(", if at any point count is negative, means not valid
            if(count < 0) {
                return false;
            }
        }
    
        return count == 0;
    }
    */

    // Optimized Approach, filter out invalid parentheses initially only
    public List<String> generateParenthesis(int n) {
        int openCount = 0;
        int closeCount = 0;
        solve("", n, openCount, closeCount);
        return result;
    }

    public void solve(String s, int n, int open, int close) {
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }

        if (open < n) {
            s += '(';
            solve(s, n, open + 1, close);
            s = s.substring(0, s.length() - 1);
        }
        if (close < open) {
            s += ')';
            solve(s, n, open, close + 1);
            s = s.substring(0, s.length() - 1);
        }
    }
}