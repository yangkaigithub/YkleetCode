package cn.yk;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[][] dp = new int[n+2][n+1];
        for (int i = n+1; i >0 ; i--) {
            for (int j = 0; j <= n ; j++) {
                if(i>j){
                    continue;
                }
                if(i==j){
                    dp[i][j] = 1;
                    continue;
                }
                if(i == j-1){
                    dp[i][j] = 2;
                    continue;
                }
                int vSum = 0;
                for (int k = i; k <= j; k++) {
                    int val = dp[i][k-1] * dp[k+1][j];
                    if(val == 0){
                        val = dp[i][k-1] + dp[k+1][j];
                    }
                    vSum += val;
                }
                dp[i][j] = vSum;

            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        new UniqueBinarySearchTrees().numTrees(3);
    }
}
