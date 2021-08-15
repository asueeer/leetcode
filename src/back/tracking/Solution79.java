package back.tracking;

import java.util.ArrayList;

/**
 * @author wangyisu
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int[][] flag = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[] start = new int[]{i,j};
                flag[start[0]][start[1]] = 1;
                if(findWord(board, word, start, flag)){
                    return true;
                }
                flag[start[0]][start[1]] = 0;
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, String word, int[] start, int[][] flag) {
        if(word.length()==1 && board[start[0]][start[1]]==word.charAt(0)){
            return true;
        }
        if(board[start[0]][start[1]]!=word.charAt(0)){
            return false;
        }
        ArrayList<ArrayList<Integer>> NextSteps = findNextStep(board,word,flag,start);
        for (int i = 0; i < NextSteps.size(); i++) {
            flag[NextSteps.get(i).get(0)][NextSteps.get(i).get(1)] = 1;
            if(findWord(board,word.substring(1),new int[]{NextSteps.get(i).get(0),NextSteps.get(i).get(1)},flag)){
                return true;
            }
            flag[NextSteps.get(i).get(0)][NextSteps.get(i).get(1)] = 0;
        }
        return false;
    }

    public static ArrayList<ArrayList<Integer>> findNextStep(char[][] board, String word, int[][] flag, int[] start) {
        ArrayList<ArrayList<Integer>> NextSteps = new ArrayList<>();
        int[][] nexts = new int[][]{{start[0]-1,start[1]},{start[0]+1,start[1]},{start[0],start[1]-1},{start[0],start[1]+1}};
        for (int i = 0; i<nexts.length; i++) {
            try{
                if(flag[nexts[i][0]][nexts[i][1]]==0 && board[nexts[i][0]][nexts[i][1]]==word.charAt(1)){
                    ArrayList<Integer> step = new ArrayList<>();
                    step.add(nexts[i][0]);
                    step.add(nexts[i][1]);
                    NextSteps.add(step);
                }
            } catch (Exception e) {
                System.out.println("数组越界");
            }
        }
        return NextSteps;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
