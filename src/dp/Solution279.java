package dp;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author wangyisu
 */
public class Solution279 {
    // numSquares(n) = min{numSquares(n - k) + 1}, ∀k ∈ square numbers
    public static HashMap<Integer, Integer> record = new HashMap<>();
    public static ArrayList<Integer> squareNumbers = new ArrayList<>();
    public static int maxNumber = 0;
    public int numSquares(int n){
        if(record.containsKey(n)){
            return record.get(n);
        }
        if(n==1){
            record.put(1, 1);
            return 1;
        }
        if(n==0){
            record.put(0,0);
        }
        if(n>maxNumber*maxNumber){
            while (maxNumber*maxNumber<n){
                maxNumber++;
                squareNumbers.add(maxNumber*maxNumber);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = squareNumbers.size() - 1; i >= 0; i--) {
            if(squareNumbers.get(i)==n){
                result = 1;
                break;
            }
            if(squareNumbers.get(i)<n){
                int key = n - squareNumbers.get(i);
                if(!record.containsKey(key)){
                    record.put(key, numSquares(key));
                }
                result = Math.min(numSquares(key) + 1, result);
            }
        }
        record.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        Solution279 solu = new Solution279();
//        System.out.println(solu.numSquares(0));
        System.out.println(solu.numSquares(12));
        System.out.println(solu.numSquares(9));
        System.out.println(solu.numSquares(13));
    }
}
