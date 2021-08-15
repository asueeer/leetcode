package back.tracking;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution37 {
    public static void solveSudoku(char[][] board) {
        if(noDot(board)){
            if(isValidSudoku(board)){
                return ;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='.'){
                    for (int k = 1; k < 10; k++) {
                        board[i][j] = (char) ('0'+k);
                        if(isValidSudoku(board)){
                            print2DArray(board);
                            solveSudoku(board);
                            if(noDot(board)&&isValidSudoku(board)){
                                return;
                            }
                        }
                        board[i][j] = '.';
                    }
                    if(board[i][j]=='.'){
                        return;
                    }
                }
            }
        }
    }

    public static void print2DArray(char[][] board){
        for (int i = 0; i < board.length; i++) {
            System.out.println(String.valueOf(board[i]));
        }
    }

    public static void print2DArray(int[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(" "+board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean noDot(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                if(board[i][j]=='.'){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        // 检查每一行
        for (int i = 0; i < board.length; i++) {
            char[][] row = new char[1][9];
            for (int j = 0; j < board[0].length; j++) {
                row[0][j] = board[i][j];
            }
            if(!isValidSection(row)){
                return false;
            }
        }
        // 检查每一列
        for (int i = 0; i < board[0].length; i++) {
            char[][] line = new char[1][9];
            for (int j = 0; j < board.length; j++) {
                line[0][j] = board[j][i];
            }
            if(!isValidSection(line)){
                return false;
            }
        }
        // 检查每一个section
        for (int i = 0; i < board.length/3; i++) {
            char[][] section = new char[3][3];
            for (int j = 0; j < board[0].length/3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        section[k][l] = board[k+i*3][l+j*3];
                    }
                }
                if(!isValidSection(section)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidSection(char[][] section){
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            hashMap.put(Integer.toString(i),0);
        }
        hashMap.put(".",0);
        for (int i = 0; i < section.length; i++) {
            for (int j = 0; j < section[0].length; j++) {
                String value = Character.toString(section[i][j]);
                hashMap.put(value,hashMap.get(value)+1);
            }
        }
        for (int i = 1; i < 10; i++) {
            if(hashMap.get(Integer.toString(i))>1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
