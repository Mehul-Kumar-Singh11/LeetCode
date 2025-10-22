class Solution {
    public int longestPalindromeSubseq(String s) {
        // This question is the variation of LCS Problem.

        // If we reverse the string s (say t) and find the LCS for (s, t) => will give the longest palindrome subsequence.

        String t = new StringBuilder(s).reverse().toString(); // reverse string s
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1]; // will store the lcs when s has length i and t has length j

        // DP using Tabulation
        for (int i = 0; i < n + 1; i++) {
            // if either of the string exhausts => no subsequence possible
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) { // if matched
                    // increase subsequence length by 1 and explore further
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // if not match
                    // decrease length either of string and explore further
                    int option1 = dp[i - 1][j];
                    int option2 = dp[i][j - 1];
                    dp[i][j] = Math.max(option1, option2); // take max length
                }
            }
        }
        return dp[n][n];
    }
}