package dp;

import java.util.Arrays;

import static java.util.Arrays.sort;

/**
 * @author wangyisu
 */
public class Solution322 {
    public static int result = Integer.MAX_VALUE;
    public static int[] coins;
    public int coinChange(int[] coins, int amount) {
        result = Integer.MAX_VALUE;
        int num_coins = 0;
        sort(coins);
        int[] coins_ = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            coins_[i] = coins[coins.length - 1 - i];
        }
        System.out.println(Arrays.toString(coins_));
        search(coins_, amount, num_coins);
        if(result==Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }

    public void search(int[] coins, int amount, int num_coins){
//        System.out.println(amount);
//        System.out.println(num_coins);
        if(num_coins>=result){
            return;
        }
        if(amount==0){
//            System.out.println("!!!!");
//            System.out.println(num_coins);
            result = Math.min(result, num_coins);
            return;
        }else if (amount<0){
//            System.out.println();
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            search(coins, amount - coins[i], num_coins+1);
        }
    }

    public static void main(String[] args) {
        Solution322 solu = new Solution322();
        System.out.println(solu.coinChange(new int[]{1,2,5}, 11));
        System.out.println(solu.coinChange(new int[]{2}, 3));
        System.out.println(solu.coinChange(new int[]{1,2,5}, 100));
    }
}
