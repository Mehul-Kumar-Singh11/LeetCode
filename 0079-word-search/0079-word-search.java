class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        if(m*n < 1) {
            return false;
        } 

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(solve(board, i, j, 0, directions, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean solve(char[][] board, int i, int j, int idx, int[][] dirs, String word) {
        if(idx == word.length()) {
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] == '$' || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char temp = word.charAt(idx);
        board[i][j] = '$';
        for(int[] dir : dirs) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            if(solve(board, i_, j_, idx+1, dirs, word)){
                return true;
            }    
        }
        board[i][j] = temp;
        return false;
    }
}