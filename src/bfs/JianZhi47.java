package bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class JianZhi47 {
    private static final HashMap<String, Integer> record = new HashMap<>();

    public static int maxValue(int[][] grid) {
        //[
        //  [1,3,1],
        //  [1,5,1],
        //  [4,2,1]
        //]
//        record.clear();
//        Queue<int[]> que = new LinkedList<>();
//        que.offer(new int[]{0, 0});
//        bfs(grid, new int[]{grid.length - 1, grid[0].length - 1}, 0, que);
//        return record.get((grid.length - 1) + " " + (grid[0].length - 1)); // "2 2"

        // 1
        // 0 0 0
        // 0 1 0
        // 0 0 0
        int[][] newGrid = new int[grid.length + 2][grid[0].length + 2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                newGrid[i + 1][j + 1] = grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(newGrid));
        return dp(grid);
    }


    //  dp[i][j] = max(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j])
    public static void dfs(int[][] grid, int[] cur, int[] end, int val) {
        boolean breakEdge = (cur[0] > grid.length - 1) || (cur[1] > grid[0].length - 1);
        if (breakEdge) {
            return;
        }
        val += grid[cur[0]][cur[1]];
        String point = cur[0] + " " + cur[1];
        if (record.containsKey(point)) {
            record.put(point, Math.max(val, record.get(point))); // update
        } else {
            record.put(point, val);
        }
        if (cur[0] == end[0] && cur[1] == end[1]) {
            return;
        }
        if (val < record.get(point)) { // 剪枝
            return;
        }
        int[][] directions = new int[][]{{1, 0}, {0, 1}};
        for (int[] direction : directions) {
            dfs(grid, new int[]{cur[0] + direction[0], cur[1] + direction[1]}, end, val);
        }
    }

    public static void bfs(int[][] grid, int[] end, int val, Queue<int[]> que) {
        // "同时"
        while (!que.isEmpty()) {
            que.poll();
        }
        return;
    }

    public static int dp(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        // 1 2 5
        // 3 2 1
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j]; // 从左边走过来的
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j]; // 从上边走过来的
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
//        System.out.println(maxValue(new int[][]{{1, 2, 5}, {3, 2, 1}}));
//        System.out.println(maxValue(new int[][]{{0}}));
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                break;
            }
            System.out.println(i);
        }
    }
}
