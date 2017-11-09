public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int cnt = 1;
        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-i-1; j++) {
                ans[i][j] = cnt++;
            }
            for (int j = i; j < n-i-1; j++) {
                ans[j][n-i-1] = cnt++;
            }
            for (int j = i; j < n-i-1; j++) {
                ans[n-i-1][n-j-1] = cnt++;
            }
            for (int j = i; j < n-i-1; j++) {
                ans[n-j-1][i] = cnt++;
            }
        }
        if(n%2 == 1){
            ans[n/2][n/2] = n*n;
        }
        return ans;
    }

    public static void main(String[] args) {
        new SpiralMatrixII().generateMatrix(3);
    }
}
