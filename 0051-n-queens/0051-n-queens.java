public class Solution {
    // Optimised Approach 
    /* IsValid is using for loops, which are taking extra O(n), we can reduce it, having 3 hashSets- cols, //diags, and antidiags. */

    private static List<List<String>> result2 = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
         result2.clear(); // clear old results
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
