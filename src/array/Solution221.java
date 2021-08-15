package array;

/**
 * @author wangyisu
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int expect = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]=='1'){
                    expect++;
                }
            }
        }
        int sidelength = ((int) Math.sqrt(expect)) + 1;
        while(true){
            sidelength--;
            boolean flag = false; // flag表示matrix包含边长为sideLength的正方形
            // Todo
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if(hasTheSquare(matrix, new int[]{i,j}, sidelength)){
                        flag=true;
                    }
                }
            }
            if(flag){
                return sidelength*sidelength; // 返回面积
            }
            if(sidelength==0){
                return 0;
            }
        }
    }

    // start为正方形起始点，有没有边长为sidelength的正方形
    boolean hasTheSquare(char[][] matrix, int[] start, int sidelength){
        int x = start[0];
        int y = start[1];
        try{
            for (int i = 0; i < sidelength; i++) {
                for (int j = 0; j < sidelength; j++) {
                    if(matrix[x+i][y+j]=='0'){
                        return false;
                    }
                }
            }
        } catch (Exception e) {
           return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
