package stock;

/**
 * @author wangyisu
 */
public class Solution188 {
    public static int count;
    public static int limit;
    public int maxProfit(int k, int[] prices) {
        count=0;
        limit = k;
        findMaxProfit(prices, 0, -1, 0, 0);
        return count;
    }

    private void findMaxProfit(int[] prices, int fee, int stockHold, int money, int haveBought) {
        if(haveBought==limit){
            prices = new int[0];
        }
        if(prices.length==0){
            if(money>count){
                count=money;
            }
            return;
        }
        int[] newPrices = new int[prices.length-1];
        if(newPrices.length!=0){
            System.arraycopy(prices,1,newPrices,0,newPrices.length);
        }
        if(stockHold==-1){
            stockHold = prices[0]; // 买它
            findMaxProfit(newPrices, fee, stockHold, money, haveBought);
            stockHold = -1; // 方便之后回溯，还要讨论不买的情况
        }else{
            int stockHoldNow = stockHold;
            int moneyNow = money;
            if(prices[0]>(stockHold+fee)){ // 可以卖
                money+=prices[0]-stockHold-fee;
                stockHold = -1;
                findMaxProfit(newPrices, fee, stockHold, money, haveBought+1);
            }
            stockHold = stockHoldNow;
            money = moneyNow;
        }
        findMaxProfit(newPrices, fee, stockHold, money, haveBought);
    }
}
