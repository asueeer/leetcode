package stock;

/**
 * @author wangyisu
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                int value = prices[j] - prices[i];
                if(value>0){
                    if(profit<value){
                        profit = prices[j] - prices[i];
                    }
                }
            }
        }
        return profit;
    }
}
