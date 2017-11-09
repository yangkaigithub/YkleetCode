public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0){
            return 0;
        }
        if(obstacleGrid[0].length==0){
            return 0;
        }
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = obstacleGrid.length-1; i >=0; i--) {
            for (int j = obstacleGrid[0].length-1; j >=0 ; j--) {
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                    continue;
                }
                if(i==obstacleGrid.length-1||j==obstacleGrid[0].length-1){
                    if(i==obstacleGrid.length-1&&j==obstacleGrid[0].length-1){
                        dp[i][j] = 1;
                    }else if(i==obstacleGrid.length-1&&j!=obstacleGrid[0].length-1) {
                        dp[i][j] = dp[i][j+1];
                    }else{
                        dp[i][j] = dp[i+1][j];
                    }

                }else{
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] a = new int[1][1];
        a[0][0] = 0;
        new UniquePathsII().uniquePathsWithObstacles(a);
    }
}
