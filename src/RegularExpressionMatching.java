import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/2/7.
 */
public class RegularExpressionMatching {
    public static void main(String[] args){
        String s;
        String p;

        s = "dd";
        p = "c*";


        System.out.println(new RegularExpressionMatching().isMatch(s, p));
    }
    public boolean isMatch(String s, String p) {
        if(s == null||p == null||p.contains("**"))
            return  false;
        if(p.length()!=0&&p.charAt(0)=='*')
            return  false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i) == '*')
                if(i>=1&&dp[0][i-1]==true)
                    dp[0][i+1] = true;
        }
        for(int i=0;i<s.length();i++)
            for(int j=0;j<p.length();j++){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')
                    dp[i+1][j+1] = dp[i][j];
                if(p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.')
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    else
                        dp[i+1][j+1] = dp[i+1][j-1]||dp[i][j+1]||dp[i+1][j];
                }
            }
        return dp[s.length()][p.length()];
    }

}
