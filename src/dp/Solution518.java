package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static java.util.Collections.sort;

/**
 * @author wangyisu
 */
public class Solution518 {
    public static HashSet<String> record = new HashSet<>();
    public static HashMap<Integer, Integer> Amount2Result = new HashMap<>();
    public static HashSet<Integer> added = new HashSet<>();
    public int change(int amount, int[] coins) {
        System.out.println(Amount2Result);
        if(Amount2Result.containsKey(amount)){
            return Amount2Result.get(amount);
        }
//        System.out.println(amount);
        if(amount>10){
            int result = 0;
            for (int i = 0; i < coins.length; i++) {
                int key = amount - coins[i];
                if(!added.contains(key)){
                    added.add(key);
                    result+=change(amount - coins[i], coins);
                }
            }
            Amount2Result.put(amount, result);
            return result;
        }
        record.clear();
        ArrayList<Integer> list = new ArrayList<>();
        search(amount, coins, list);
        Amount2Result.put(amount, record.size());
        return record.size();
    }

    public void search(int amount, int[] coins, ArrayList<Integer> list){
        if(amount==0){
            sort(list);
            record.add(list.toString());
            return;
        }else if (amount<0){
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            ArrayList<Integer> newList = new ArrayList<>(list);
            newList.add(coins[i]);
            search(amount - coins[i], coins, newList);
        }
    }

    public static void main(String[] args) {
        Solution518 solu = new Solution518();
        System.out.println(solu.change(500, new int[]{1,2,5}));
//        System.out.println(solu.change(5, new int[]{1,2,5}));
//        System.out.println(solu.change(5, new int[]{2,5}));
//        System.out.println(solu.change(3, new int[]{2}));
//        System.out.println(solu.change(11, new int[]{1,2,5}));
    }
}
