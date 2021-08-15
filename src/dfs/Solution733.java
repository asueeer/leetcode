package dfs;

import tree.Solution111;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution733 {
    HashMap<String, int[]> shouldBeChanged;
    // 把相邻的连通块重新上色
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        shouldBeChanged = new HashMap<>();
        dfs(new int[]{sr, sc}, image);
        for (String s : shouldBeChanged.keySet()) {
            int[] pixel = shouldBeChanged.get(s);
            image[pixel[0]][pixel[1]] = newColor;
        }
        return image;
    }

    // 把image中的pixel的连通块放进shouldBeChanged
    private void dfs(int[] pixel, int[][] image) {
        if(shouldBeChanged.containsKey(Arrays.toString(pixel))){
            return;
        }else{
            shouldBeChanged.put(Arrays.toString(pixel), pixel);
        }
        int[][] direction = new int[][]{{-1, 0}, {1,0},{0,1},{0,-1}};
        for (int i = 0; i < direction.length; i++) {
            try{
                int[] adjacentPixel = new int[]{pixel[0]+direction[i][0], pixel[1]+direction[i][1]};
                if(image[adjacentPixel[0]][adjacentPixel[1]]==image[pixel[0]][pixel[1]]){
                    if(!shouldBeChanged.containsKey(Arrays.toString(adjacentPixel))){
                        dfs(adjacentPixel, image);
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        Solution733 solu = new Solution733();
        System.out.println(Arrays.deepToString(solu.floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1,2)));
    }
}
