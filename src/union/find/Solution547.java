package union.find;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution547 {
    public int findCircleNum(int[][] M) {
        HashMap<Integer, Integer> fathers = new HashMap<>();
        for (int i = 0; i < M.length; i++) {
            fathers.put(i,-1);
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if(M[i][j]==1 && i!=j){
                    union(fathers, i,j);
                }
            }
        }

        int circles = 0;
        for (int i = 0; i < M.length; i++) {
            if(fathers.get(i)==-1){
                circles++;
            }
        }
        return circles;
    }

    // 连接i和j的父亲
    private void union(HashMap<Integer, Integer> fathers, int i, int j) {
        i = findFather(fathers, i);
        j = findFather(fathers, j);
        if(i!=j){
            fathers.put(i,j);
        }
    }

    private int findFather(HashMap<Integer, Integer> fathers, int i) {
        if(fathers.get(i)==-1){
            return i;
        }
        return findFather(fathers,fathers.get(i));
    }
}
