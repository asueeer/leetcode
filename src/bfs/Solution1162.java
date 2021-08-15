package bfs;

/**
 * @author wangyisu
 */
public class Solution1162 {
    // 填海造陆
    public static int maxDistance(int[][] grid) {
        if(noLand(grid)||noSea(grid)){
            return -1;
        }
        int[][] flag = new int[grid.length][grid[0].length];
        int len = 0;
        while(!travelEveryWhere(flag)){
            if(noSea(grid)){
                break;
            }
            flag = new int[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j]==1 && flag[i][j]==0){
                        fillAdjacentArea(grid, flag, i, j);
                    }
                }
            }
            len++;
        }
        return len;
    }

    private static boolean noLand(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean noSea(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

    private static void fillAdjacentArea(int[][] grid, int[][] flag, int i, int j) {
        int[][] next = new int[][]{{i+1,j},{i-1,j},{i,j+1},{i,j-1}};
        for (int k = 0; k < next.length; k++) {
            try{
                if(grid[next[k][0]][next[k][1]]==0){
                    grid[next[k][0]][next[k][1]] = 1;
                    flag[next[k][0]][next[k][1]] = 1;
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    private static boolean travelEveryWhere(int[][] flag) {
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[0].length; j++) {
                if(flag[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}}));
    }
}
