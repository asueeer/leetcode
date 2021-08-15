package stock;

/**
 * @author wangyisu
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int i = 0;
        int profitCount = 0;
        while(i<prices.length-1){
            int j = i;
            while(j<prices.length-1){
                if(prices[j]<prices[i]){
                    break;
                }else{
                    j++;
                }
                int value = prices[j]-prices[i];
                if(value>0){
                    profitCount+=prices[j]-prices[i];
                }
                i = j;
            }
        }
        return profitCount;
    }
}
