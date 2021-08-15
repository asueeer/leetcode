package array;

/**
 * @author wangyisu
 */
public class Solution289 {
    public static void gameOfLife(int[][] board) {
//        1-活的   0-死的  2-之前是死的，现在复活的 3-之前是活的，现在是死的
//        如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
//        如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
//        如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
//        如果死细胞周围正好有三个活细胞，则该位置死细胞复活；

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[][] adjoin = new int[][]{{i-1,j-1},{i-1,j},{i-1,j+1},{i,j-1},{i,j+1},{i+1,j-1},{i+1,j},{i+1,j+1}};
                int n_live = aliveCount(adjoin,board,i,j); // n为周围的活细胞
                if(n_live<2){
                    if(board[i][j]==1){
                        board[i][j] = 3;
                    }
                }
                if(n_live>3){
                    if(board[i][j]==1){
                        board[i][j] = 3;
                    }
                }
                if(n_live==3){
                    if(board[i][j]==0){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==2){
                    board[i][j] = 1;
                }
                if(board[i][j]==3){
                    board[i][j] = 0;
                }
            }
        }
    }

    private static int aliveCount(int[][] adjoin, int[][] board, int i, int j) {
        int n_live = 0;

        for (int k = 0; k < adjoin.length; k++) {
            try{
                int state = board[adjoin[k][0]][adjoin[k][1]];
                if(state==1 || state==3){
                    n_live++;
                }
            } catch (Exception e) {

            }
        }
        return n_live;
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        System.out.println(board[1][0]);
    }
}
