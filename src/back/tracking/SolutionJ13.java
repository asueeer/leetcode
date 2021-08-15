package back.tracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author wangyisu
 */
public class SolutionJ13 {
    public static int[][] map;
    public int movingCount(int m, int n, int k) {
        HashMap<String, Integer> visited = new HashMap<>();
        map = new int[m][n];
        roam(0, 0, k, visited);
        int count = 0;
        for(Map.Entry<String, Integer> entry: visited.entrySet()){
            if(entry.getValue()==1){
                count++;
            }
        }
        return count;
    }

    private void roam(int x, int y, int k, HashMap<String, Integer> visited) {
        String s = String.valueOf(x)+" "+String.valueOf(y);
        if(rowLineIndexSum(x,y)>k){
            visited.put(s,0);
            return;
        }
        try{
            int temp = map[x][y];
        } catch (Exception e) {
            visited.put(s, 0);
            return; // 超出边界了
        }
        if(visited.containsKey(s)){
            return;
        }
        visited.put(s,1);
        int[][] nextChoices = new int[][]{{x-1,y},{x+1,y},{x,y-1},{x,y+1}};
        for (int i = 0; i < nextChoices.length; i++) {
            roam(nextChoices[i][0],nextChoices[i][1],k,visited);
        }
    }

    private int rowLineIndexSum(int x, int y) {
        if(x<0 || y<0){
            return Integer.MAX_VALUE;
        }
        String str_x = String.valueOf(x);
        String str_n = String.valueOf(y);
        int result = 0;
        for (int i = 0; i < str_x.length(); i++) {
            result += Integer.valueOf(str_x.substring(i,i+1));
        }
        for (int i = 0; i < str_n.length(); i++) {
            result += Integer.valueOf(str_n.substring(i,i+1));
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionJ13 solu = new SolutionJ13();
        System.out.println(solu.movingCount(2,3,1));
    }

}
