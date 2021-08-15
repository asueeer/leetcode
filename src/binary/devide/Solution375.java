package binary.devide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyisu
 */
public class Solution375 {
    static HashMap<String, Integer> hashMap = new HashMap<>();

    public static int getMinAmount(int lo, int hi){
        if(lo==hi){
            return 0;
        }
        if((hi-lo)==1){
            return lo;
        }
        if((hi-lo)==2){
            return lo+(hi-lo)/2;
        }

        if(hashMap.containsKey(lo +" "+ hi)){
            return hashMap.get(lo +" "+ hi);
        }
        int min_ = Integer.MAX_VALUE;
        int temp = 0;
        for (int i = lo + 1; i < hi; i++) {
            temp = i + Math.max(getMinAmount(lo,i-1),getMinAmount(i+1,hi));
            if(temp<min_){
                min_ = temp;
            }
        }
        hashMap.put(lo+" "+hi,min_);
        return min_;
    }

    public int getMoneyAmount(int n) {
        return getMinAmount(1,n);
    }

    public static void main(String[] args) {
            Solution375 solution375 = new Solution375();
            System.out.println(solution375.getMoneyAmount(99));
    }
}
