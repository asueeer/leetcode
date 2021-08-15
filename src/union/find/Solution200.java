package union.find;

import java.util.HashMap;

/**
 * @author wangyisu
 */
public class Solution200 {
    public static int numIslands(char[][] grid) {
        HashMap<String, String> fathers = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                fathers.put(String.valueOf(i)+" "+String.valueOf(j), "#");
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    process(fathers, grid, i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(fathers.get(String.valueOf(i)+" "+String.valueOf(j)).equals("#")){
                    if(grid[i][j]=='1'){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static void process(HashMap<String, String> fathers, char[][] grid, int i, int j) {
        int[][] adjacent = new int[][]{{i-1,j},{i+1,j},{i,j-1},{i,j+1}};
//        System.out.println("jo");
        for (int k = 0; k < adjacent.length; k++) {
            try{
                if(grid[adjacent[k][0]][adjacent[k][1]]=='1'){
                    union(fathers, String.valueOf(adjacent[k][0])+" "+String.valueOf(adjacent[k][1]), String.valueOf(i)+" "+String.valueOf(j));
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
    }

    private static void union(HashMap<String, String> fathers, String s1, String s2) {
        s1 = findFather(fathers, s1);
        s2 = findFather(fathers, s2);
        if(!s2.equals(s1)){
            fathers.put(s1,s2);
        }
    }

    private static String findFather(HashMap<String, String> fathers, String s) {
        if(fathers.get(s).equals("#")){
            return s;
        }
        return findFather(fathers,fathers.get(s));
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
    }

}
