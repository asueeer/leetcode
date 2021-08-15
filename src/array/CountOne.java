package array;

import java.util.HashMap;
import java.util.HashSet;
public class CountOne {
    HashMap<Integer, Integer> fibs = new HashMap<>();
    public int fibCountOne(int n){
        if(n==2){
            return 1;
        }
        getfib(n);
        HashSet<String> fibsString = new HashSet<>();
        for (Integer i : fibs.keySet()) {
            int fib = fibs.get(i);
            fibsString.add(String.valueOf(fib));
        }
        return CountOne(fibsString);
    }

    public int CountOne(HashSet<String> strings){
        int result = 1;
        for (String string : strings) {
            System.out.println(string);
            for (int i = 0; i < string.length(); i++) {
                if(string.charAt(i)=='1'){
                    result++;
                }
            }
        }
        return result;
    }

    private int getfib(int n) {
        if(fibs.containsKey(n)){
            return fibs.get(n);
        }
        if(n==0){
            fibs.put(0,0);
            return 0;
        }
        if(n==1){
            fibs.put(1,1);
            return 1;
        }
        if(n==2){
            fibs.put(2,1);
            return 1;
        }
        fibs.put(n, getfib(n-1) + getfib(n-2));
        return fibs.get(n);
    }

    public static void main(String[] args) {
        CountOne co = new CountOne();
        System.out.println(co.fibCountOne(10));
        System.out.println(co.fibs);
    }
}
