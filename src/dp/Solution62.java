package dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wangyisu
 */
public class Solution62 {
    public static int[] Finish = new int[2];
    public static int result;
    public static HashMap<String, Integer> record = new HashMap<>();
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }
        String key = m + " " + n;
        if(record.containsKey(key)){
            return record.get(key);
        }
        if(m>15 || n >15){
            result  = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
            record.put(key, result);
            return result;
        }
        Finish[0] = Math.max(m,n);
        Finish[1] = Math.min(m,n);
        int[] start = new int[2];
        start[0] = 1;
        start[1] = 1;
        result = 0;
        roam(start);
        record.put(key, result);
        return result;
    }

    private void roam(int[] start) {
        if(start[0]==Finish[0] && start[1]==Finish[1]){
            result++;
            return;
        }
        if(!(start[0]<=Finish[0] && start[1]<=Finish[1])){
            return;
        }
        start[0]++;
        if(start[0]<=Finish[0]){
            roam(start);
        }
        start[0]--;
        start[1]++;
        if(start[1]<=Finish[0]){
            roam(start);
        }
        start[1]--;
    }

    public static void main(String[] args) {
        Solution62 solu = new Solution62();
        System.out.println(solu.uniquePaths(3, 2));
        System.out.println(solu.uniquePaths(7, 3));
        System.out.println(solu.uniquePaths(3,7));
        System.out.println(solu.uniquePaths(23,12));
    }
}
