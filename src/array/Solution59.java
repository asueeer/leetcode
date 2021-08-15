package array;

import javax.swing.table.TableRowSorter;
import java.util.Arrays;

/**
 * @author wangyisu
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[] direction = new int[]{0,1};
        int[] point = new int[]{0, 0};
        int value = 1;
//        System.out.println(Arrays.toString(direction));
        for (int i = 0; i < n*n*2; i++) {
            matrix[point[0]][point[1]] = value;
            value++;
            int[] newPoint = new int[]{point[0]+direction[0], point[1]+direction[1]};
            boolean shouldChangeDirection = false;
            System.out.println("d "+Arrays.toString(direction));
            try{
                System.out.println(Arrays.toString(newPoint));
                if(matrix[newPoint[0]][newPoint[1]]!=0){
                    shouldChangeDirection = true;
                }
            } catch (Exception e) {
                shouldChangeDirection = true;
            }
            if(shouldChangeDirection){
                if(direction[0]==0 && direction[1]==1){
                    direction = new int[]{1, 0};
                    System.out.println("d !!!!"+Arrays.toString(direction));
                }else if(direction[0]==1 && direction[1]==0){
                    direction = new int[]{0, -1};
                }else if(Arrays.toString(direction).equals("[0, -1]")){
                    direction = new int[]{-1, 0};
                }else if(Arrays.toString(direction).equals("[-1, 0]")){
                    direction = new int[]{0, 1};
                }
                value--;
                continue;
            }
            point = newPoint;
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution59 solu = new Solution59();
        System.out.println(Arrays.deepToString(solu.generateMatrix(4)));
    }
}
