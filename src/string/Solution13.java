package string;

import com.sun.jdi.event.StepEvent;

import java.util.HashMap;

/**
 * @author wangyisu
 */
public class Solution13 {
    public static int romanToInt(String str) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] reps = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        HashMap<String,Integer> dict = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            dict.put(reps[i],values[i]);
        }
        int i = 0;
        int num = 0;
        while(i<str.length()){
            try{
                if(dict.containsKey(str.substring(i,i+2))){
                    num+=dict.get(str.substring(i,i+2));
                    i+=2;
                }else{
                    num+=dict.get(str.substring(i,i+1));
                    i+=1;
                }
            } catch (Exception e) {
                num+=dict.get(str.substring(i,i+1));
                i+=1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
