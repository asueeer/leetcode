package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static java.util.Collections.sort;

/**
 * @author wangyisu
 */
public class Solution518_edition2 { // 参考了左神的代码
    public static ArrayList<Integer> coins_ = new ArrayList<>();
    public static HashSet<String> record = new HashSet<>();
    public static HashSet<String> computed = new HashSet<>();
    public int change(int amount, int[] coins) {
        if(coins.length==0){
            if(amount==0){
                return 1;
            }else{
                return 0;
            }
        }
        computed.clear();
        coins_.clear();
        record.clear();
        for (int i = 0; i < coins.length; i++) {
            coins_.add(coins[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        process(amount, coins_, list);
        return record.size();
    }

    private void process(int amount, ArrayList<Integer> coins_, ArrayList<Integer> list) {
        String key = amount+" "+ coins_.toString() + list.toString();
        if(computed.contains(key)){
            return;
        }else{
            computed.add(key);
        }
        if(coins_.size()==1){
            if(amount%coins_.get(0)==0){
                list.add(amount/coins_.get(0));
                record.add(list.toString());
            }
            return;
        }
        for (int i = 0; i < coins_.size(); i++) {
            ArrayList<Integer> new_coins = new ArrayList<>(coins_);
            new_coins.remove(0);
            int num = 0;
            while(amount - num*coins_.get(0)>=0){
                ArrayList<Integer> new_list = new ArrayList<Integer>(list);
                new_list.add(num);
                process(amount - num*coins_.get(0), new_coins, new_list);
                num++;
            }
        }
    }

    public static void main(String[] args) {
        Solution518_edition2 solu = new Solution518_edition2();
        System.out.println(solu.change(500, new int[]{1,2,5}));
        System.out.println(solu.change(5, new int[]{1,2,5})); // 4
        System.out.println(solu.change(5, new int[]{2,5}));
        System.out.println(solu.change(3, new int[]{2}));
        System.out.println(solu.change(11, new int[]{1,2,5})); // 11
        System.out.println(solu.change(100, new int[]{3,5,7,8,9,10,11})); // 6606
        System.out.println(solu.change(500,new int[]{3,5,7,8,9,10,11}));
        System.out.println(record);
    }
}
