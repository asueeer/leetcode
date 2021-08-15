package union.find;

import java.util.HashMap;

/**
 * @author wangyisu
 */
public class Solution130 {
    public static void solve(char[][] board) {
        HashMap<String, String> fathers = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                fathers.put(String.valueOf(i)+" "+String.valueOf(j), "#");
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]=='O'){
                    process(fathers, board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String s = String.valueOf(i)+" "+String.valueOf(j);
                if(board[i][j]=='O' && !isInEdge(board,findFather(fathers,s))){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void process(HashMap<String, String> fathers, char[][] board, int i, int j) {
        int[][] adjacent = new int[][]{{i-1,j},{i+1,j},{i,j-1},{i,j+1}};
        for (int k = 0; k < adjacent.length; k++) {
            try{
                if(board[adjacent[k][0]][adjacent[k][1]]=='O'){
                    union(fathers,board,String.valueOf(adjacent[k][0])+" "+String.valueOf(adjacent[k][1]), String.valueOf(i)+" "+String.valueOf(j));
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
    }

    private static void union(HashMap<String, String> fathers,char[][] board, String s1, String s2) {
        s1 = findFather(fathers, s1);
        s2 = findFather(fathers, s2);
        if(!s2.equals(s1)){
            // 如果s1是在边界上，优先将s1设为父节点
            if(isInEdge(board, s1)){
                fathers.put(s2,s1);
                return;
            }
            fathers.put(s1,s2);
        }
    }

    private static String findFather(HashMap<String, String> fathers, String s) {
        if(fathers.get(s).equals("#")){
            return s;
        }
        return findFather(fathers,fathers.get(s));
    }

    private static boolean isInEdge(char[][] board, String s){
        String[] arr = s.split(" ");
        int i = Integer.parseInt(arr[0]);
        int j = Integer.parseInt(arr[1]);
        int[][] adjacent = new int[][]{{i-1,j},{i+1,j},{i,j-1},{i,j+1}};
        for (int k = 0; k < adjacent.length; k++) {
            try {
                System.out.println(adjacent[k][0]);
                System.out.println(adjacent[k][1]);
                char ch = board[adjacent[k][0]][adjacent[k][1]];
                System.out.println(ch);
            } catch (Exception e) {
                System.out.println("hi");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] nums = new char[3][3];
        System.out.println(isInEdge(nums,"1 2"));
    }
}
