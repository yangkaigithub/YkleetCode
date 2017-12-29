package cn.yk;

import java.util.HashMap;
import java.util.Map;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0){
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] flags = new boolean[board.length][board[0].length];
                if(board[i][j] == word.charAt(0)){
                    if (word.length() == 1){
                        return true;
                    }
                    flags[i][j] = true;
                    if(dfs(board,flags,word,1,word.charAt(1),i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,boolean[][] flags,String word,int midword,char target,int row,int col){
        if(row>0&&!flags[row-1][col]&&board[row-1][col]==target){
            midword ++;
            if(midword == word.length()){
                return true;
            }
            flags[row-1][col] = true;
            if(dfs(board,flags,word,midword,word.charAt(midword),row-1,col)){
                return true;
            }else{
                midword--;
                flags[row-1][col] = false;
            }
        }
        if(col>0&&!flags[row][col-1]&&board[row][col-1]==target){
            midword ++;
            if(midword == word.length()){
                return true;
            }
            flags[row][col-1] = true;
            if(dfs(board,flags,word,midword,word.charAt(midword),row,col-1)){
                return true;
            }else{
                midword--;
                flags[row][col-1] = false;
            }
        }
        if(row+1<board.length&&!flags[row+1][col]&&board[row+1][col]==target){
            midword++;
            if(midword == word.length()){
                return true;
            }
            flags[row+1][col] = true;
            if(dfs(board,flags,word,midword,word.charAt(midword),row+1,col)){
                return true;
            }else{
                midword--;
                flags[row+1][col] = false;
            }
        }
        if(col+1<board[0].length&&!flags[row][col+1]&&board[row][col+1]==target){
            midword++;
            if(midword == word.length()){
                return true;
            }
            flags[row][col+1] = true;
            if(dfs(board,flags,word,midword,word.charAt(midword),row,col+1)){
                return true;
            }else{
                midword--;
                flags[row][col+1] = false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] c = new char[3][];
        c[0] = new char[]{'a','b','c','e'};
        c[1] = new char[]{'s','f','e','s'};
        c[2] = new char[]{'a','d','e','e'};
        System.out.println(new WordSearch().exist(c,"abceseeefs"));

    }
}
