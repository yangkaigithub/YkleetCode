public class RotateImage {
    public void rotate(int[][] matrix) {
        int tmp1 = 0;
        int tmp2 = 0;
        if (matrix.length == 0){
            return;
        }
        int l = matrix.length;
        for (int i = 0; i < l/2; i++) {
            for (int j = i; j < l-i-1; j++) {
                tmp1 = matrix[j][l-i-1];
                matrix[j][l-i-1] = matrix[i][j];
                tmp2 = matrix[l-i-1][l-j-1];
                matrix[l-i-1][l-j-1] = tmp1;
                matrix[i][j] = matrix[l-j-1][i];
                matrix[l-j-1][i] = tmp2;
            }
        }
    }

    public static void main(String[] args) {
    }
}
