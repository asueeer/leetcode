package bfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution1091_dfs {
    public static int result;
    public static int[] end;
    public static int[][] grid_;
    public static HashMap<String, Integer> record;

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] start = new int[]{0, 0};
        if(grid[start[0]][start[1]]==1){
            return -1;
        }
        end = new int[]{grid[0].length - 1, grid.length - 1};
        grid_ = grid;
        result = Integer.MAX_VALUE;
        HashSet<String> visited = new HashSet<>();
//        System.out.println(Arrays.toString(start));
//        System.out.println(Arrays.toString(end));
        record = new HashMap<>();
        int step = 1;
        dfs(start, step, visited);
        if(result==Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }

    private void dfs(int[] start, int step, HashSet<String> visited) {
        if(record.containsKey(Arrays.toString(start))){
            if(step>record.get(Arrays.toString(start))){
                return;
            }else{
                record.put(Arrays.toString(start), step);
            }
        }else{
            record.put(Arrays.toString(start), step);
        }
        if(visited.contains(Arrays.toString(start))){
            return;
        }else{
            visited.add(Arrays.toString(start));
        }
        if (step > result) {
            return;
        }
        if (Arrays.toString(start).equals(Arrays.toString(end))) {
            result = Math.min(result, step);
        }
        int[][] next_bias = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < next_bias.length; i++) {
            int[] next = new int[]{start[0] + next_bias[i][0], start[1] + next_bias[i][1]};
            try {
                if (grid_[next[0]][next[1]] == 0 && !visited.contains(Arrays.toString(next))) {
                    System.out.println("进入" + Arrays.toString(next));
                    dfs(next, step + 1, new HashSet<>(visited));
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Solution1091_dfs solu =  new Solution1091_dfs();
//        System.out.println(solu.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        System.out.println(solu.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
//        System.out.println(solu.shortestPathBinaryMatrix(new int[][]{{0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,1},{1,0,0,0,0,0,0,0},{0,0,0,0,0,1,1,0},{0,0,1,0,1,0,1,1},{0,0,0,0,0,0,0,0},{0,0,0,1,1,1,0,0},{1,0,1,1,1,0,0,0}}));
    }
}
