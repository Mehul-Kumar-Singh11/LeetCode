public class Solution {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0)
            return result;

        List<String> board = new ArrayList<>();
        // For n = 3, board = {"...", "...", "..."} initially
        for (int i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < n; j++) {
                row.append('.');
            }
            board.add(row.toString());
        }

        solve(board, 0);

        return result;
    }

    private boolean isValid(List<String> board, int row, int col) {
        // Look for up
        for (int i = row; i >= 0; i--) {
            if (board.get(i).charAt(col) == 'Q')
                return false;
        }

        // Check left diagonal upwards
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }

        // Check right diagonal upwards
        for (int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }

        return true;
    }

    private void solve(List<String> board, int row) {
        if (row == board.size()) {
            result.add(new ArrayList<>(board));
            return;
        }

        // Place one queen at every row and check before placing
        // in every direction where there is a risk of being attacked
        // i.e., up, diagonally because we are placing queens from
        // the top row to the bottom row, so we need to check if we put a queen
        // vertically up in some row or diagonally upwards in some row

        for (int i = 0; i < board.size(); i++) {
            if (isValid(board, row, i)) {
                StringBuilder newRow = new StringBuilder(board.get(row));
                newRow.setCharAt(i, 'Q');
                board.set(row, newRow.toString());

                solve(board, row + 1);

                newRow.setCharAt(i, '.');
                board.set(row, newRow.toString());
            }
        }
    }
}

// Optimised Approach 
/* IsValid is using for loops, which are taking extra O(n), we can reduce it, having 3 hashSets- cols, //diags, and antidiags. 

public class NQueens {
    private static List<List<String>> result2 = new ArrayList<>();

    public static List<List<String>> solveNQueensOptimised(int n) {
        if (n == 0) {
            return result2;
        }
        // Create board
        ArrayList<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // Create rows
            StringBuilder newRow = new StringBuilder();
            for (int j = 0; j < n; j++) {
                newRow.append('.');
            }
            board.add(newRow.toString());
        }

        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> diags = new HashSet<>();
        HashSet<Integer> antiDiags = new HashSet<>();
        int startingRow = 0;
        solveOptimized(board, startingRow, cols, diags, antiDiags);
        return result2;
    }

    public static void solveOptimized(ArrayList<String> board, int row, HashSet<Integer> cols, HashSet<Integer> diags,
            HashSet<Integer> antiDiags) {
        if (row >= board.size()) {
            result2.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            int diagId = row + col;
            int antiDiagId = row - col;
            if (cols.contains(col) || diags.contains(diagId) || antiDiags.contains(antiDiagId)) {
                continue;
            }

            cols.add(col);
            diags.add(diagId);
            antiDiags.add(antiDiagId);
            StringBuilder newRow = new StringBuilder(board.get(row));
            newRow.setCharAt(col, 'Q');
            board.set(row, newRow.toString());

            solveOptimized(board, row + 1, cols, diags, antiDiags);

            cols.remove(col);
            diags.remove(diagId);
            antiDiags.remove(antiDiagId);
            newRow.setCharAt(col, '.');
            board.set(row, newRow.toString());
        }

    }
}

*/