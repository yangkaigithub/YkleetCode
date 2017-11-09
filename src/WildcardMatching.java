public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean [][]dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;
            for(int i=1;i<dp.length;i++){
                if(p.charAt(i-1)=='*'&&dp[i-1][0]){
                    dp[i][0] = true;
                }
            }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if(p.charAt(i-1)=='*'){
                    if(dp[i][j-1]||dp[i-1][j]){
                        dp[i][j] = true;
                    }
                }else if(p.charAt(i-1)=='?'){
                    if(dp[i-1][j-1]){
                        dp[i][j] = true;
                    }
                }else{
                    if(dp[i-1][j-1]&&s.charAt(j-1)==p.charAt(i-1)){
                        dp[i][j] = true;
                    }
                }
            }

        }
        return dp[p.length()][s.length()];
    }


    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("aa","*"));
    }
}
