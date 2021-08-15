package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangyisu
 */
public class Solution54 {
    public static List<Integer> result = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        result = new ArrayList<>();
        getTheFirstRow(matrix);
        return result;
    }

    public void getTheFirstRow(int[][] matrix){
        for (int i = 0; i < matrix[0].length; i++) {
            result.add(matrix[0][i]);
        }
        if(matrix.length==1){
            return;
        }
        matrix = rotate(matrix);
        getTheFirstRow(matrix);
    }

    private int[][] rotate(int[][] matrix) {
        int[][] new_matrix = new int[matrix[0].length][matrix.length - 1];
        int row = 0;
        for (int i = matrix[0].length - 1; i > -1; i--) {
            for (int j = 0; j < new_matrix[0].length; j++) {
                new_matrix[row][j] = matrix[j+1][matrix[0].length - 1 - row];
            }
            row++;
        }
        System.out.println(Arrays.deepToString(new_matrix));
        return new_matrix;
    }

    public static void main(String[] args) {

        Solution54 solu = new Solution54();
        System.out.println(solu.spiralOrder(new int[][]{{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }}));
    }
}
