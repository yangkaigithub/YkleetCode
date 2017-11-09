public class MinimumPathSum {
    public int minPathSum(int[][] grid) {

        if(grid.length==1){
            int ans = 0;
            for (int i = 0; i < grid[0].length; i++) {
                ans += grid[0][i];
            }
            return ans;
        }
        int l = grid.length;
        int w = grid[0].length;
        int[][] dp = new int[l][w];

        dp[l-1][w-1] = grid[l-1][w-1];
        for (int i = l-2; i >=0 ; i--) {
            dp[i][w-1] = grid[i][w-1]+ dp[i+1][w-1];
        }

        for (int i = w-2; i >= 0 ; i--) {
            dp[l-1][i] = grid[l-1][i] + dp[l-1][i+1];
         }

        for (int i = l-2; i >= 0; i--) {
            for (int j = w-2; j >=0 ; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
            }

        }
        return dp[0][0];
    }
}
