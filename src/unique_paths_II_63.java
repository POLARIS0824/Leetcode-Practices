public class unique_paths_II_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // ask for dp[m - 1][n - 1] = dp[m - 1][n - 2] + dp[m - 2][n - 1]
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        dp[0][0] = 1;

        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != 1 && i > 0) {
                dp[i][0] = dp[i - 1][0];
            } else if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            }
        }

        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] != 1 && i > 0) {
                dp[0][i] = dp[0][i - 1];
            } else if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        unique_paths_II_63 test = new unique_paths_II_63();
        System.out.println(test.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
    }
}
