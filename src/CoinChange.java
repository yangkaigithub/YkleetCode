public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            int temp = -1;
            for(int coin:coins){
                if(i>=coin&&dp[i-coin]!=-1){
                    temp = dp[i-coin] + 1;
                    if(dp[i]>0) {
                        dp[i] = dp[i] < temp ? dp[i] : temp;
                    }else{
                        dp[i] = temp;
                    }
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {

    }
}
