package dp;

import java.util.HashMap;

/**
 * @author wangyisu
 */
public class Solution322_dp {
    public static HashMap<Integer, Integer> record = new HashMap<>(); // 避免了重复计算

    public int coinChange(int[] coins, int amount) { // 多了一个处理程序
        record = new HashMap<>();
        int result =  coinChange_(coins, amount);
        if(result>Integer.MAX_VALUE/3){
            return -1;
        }else{
            return result;
        }
    }

    public int coinChange_(int[] coins, int amount) {
        if(record.containsKey(amount)){
            return record.get(amount);
        }
        if(amount==0){
            return 0;
        }else if(amount<-1){
            return Integer.MAX_VALUE/2;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            result = Math.min(result, coinChange_(coins, amount - coins[i])+1);
        }
        record.put(amount, result);
        return result;
    }

    public static void main(String[] args) {
        Solution322_dp solu = new Solution322_dp();
        System.out.println(solu.coinChange(new int[]{1,2,5}, 11));
        System.out.println(solu.coinChange(new int[]{2}, 3));
        System.out.println(solu.coinChange(new int[]{1,2,5}, 100));
    }
}
