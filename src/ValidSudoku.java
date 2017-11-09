import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> rectSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]!='.'&&!rowSet.add(board[i][j])){
                    return false;
                }
                if(board[j][i]!='.'&&!colSet.add(board[j][i])){
                    return false;
                }
                int rowIndex = i/3*3;
                int colIndex = i%3*3;
                if(board[rowIndex+j/3][colIndex+j%3]!='.'&&!rectSet.add(board[rowIndex+j/3][colIndex+j%3])){
                    return false;
                }
            }

        }
        return true;
    }
}
