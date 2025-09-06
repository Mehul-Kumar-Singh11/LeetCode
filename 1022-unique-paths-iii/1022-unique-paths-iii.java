class Solution {
    static int result=0;
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int uniquePathsIII(int[][] grid) {
        int x=0;
        int y=0;
        int nonObstaclesCount = 0;
        // count all walkable cells and locate starting point
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] != -1) { // count all walkable cells
                    nonObstaclesCount++;
                }
                if(grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        result = 0;
        backtrack(grid, x, y, 1, nonObstaclesCount); // start already visited
        return result;
    }

    public static void backtrack(int[][] grid, int i, int j, int noOfCellsVisited, int nonObstaclesCount) {
        // out of bounds or obstacle
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == -1) {
            return;
        }
        // base case
        if(grid[i][j] == 2) {
            if(noOfCellsVisited == nonObstaclesCount) {
                result++;
            }
            return;
        }
        // mark as visited
        int temp = grid[i][j];
        grid[i][j] = -1;
        for(int[] dir: directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            backtrack(grid, i_, j_, noOfCellsVisited+1, nonObstaclesCount);
        }
        // backtrack
        grid[i][j] = temp;

    }
}