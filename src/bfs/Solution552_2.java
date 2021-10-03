package bfs;

import java.util.HashMap;
import java.util.HashSet;

public class Solution552_2 {

    //         // 当入参为n时，
    //        // 此时结束的状态为xy,
    //        // x表示A出现的数量,y为1表示最后一个是L, y为2表示最后两个都是L
    //        // 下列式子的[]就相当于*1
    public HashMap<String, Integer> record = new HashMap<>();
    long mod = (long) (1e9 + 7);

    public int checkRecord(int num) {
        if (num <= 0) {
            return 0;
        }
        if (num == 1) {
            return 3;
        }
        if (num == 2) {
            return 8;
        }
        record.put("00", 2); // PP LP
        record.put("10", 3); // AP LA PA
        record.put("11", 1); // AL
        record.put("01", 1); // PL
        record.put("12", 0); // 无
        record.put("02", 1); // LL
        // 3 00 LLP LPP PLP PPP
        // 3 10 LLA LPA ALP APP PLA PPA PAL PAP LAP
        // 3 01 LPL PPL
        // 3 11 LAL APL
        // 3 12 ALL
        // 3 02 PLL
        int result = 0;
        for (int n = 3; n <= num; n++) {
            // 1. f(n+1,00) = f(n,00)[c=='P'] + f(n,01)[c=='P'] + f(n,02)[c=='P']
            int valueN_00 = add(
                    record.get("00"),
                    record.get("01"),
                    record.get("02"));
            // 2. f(n+1,10) = f(n,00)[c=='A'] + f(n,01)[c=='A'] + f(n,02)[c=='A']
            //             + f(n,11)[c=='P'] + f(n,12)[c=='P'] + f(n,10)[c=='P']
            int valueN_10 = add(record.get("00"),
                    record.get("01"),
                    record.get("02"),
                    record.get("11"),
                    record.get("12"),
                    record.get("10"));

            // 3. f(n+1,01) = f(n,00)[c=='L']
            int valueN_01 = record.get("00");

            // 4. f(n+1, 11) = f(n,10)[c=='L']
            int valueN_11 = record.get("10");

            // 5. f(n+1,12) = f(n,11)[c=='L']
            int valueN_12 = record.get("11");

            // 6. f(n+1,02) = f(n,01)[c=='L']
            int valueN_02 = record.get("01");


            record.put("00", valueN_00);
            record.put("02", valueN_02);
            record.put("12", valueN_12);
            record.put("11", valueN_11);
            record.put("01", valueN_01);
            record.put("10", valueN_10);
            result = add(valueN_00, valueN_10, valueN_01, valueN_11, valueN_12, valueN_02);
        }
        return result;
    }

    int add(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum = (int) ((sum + num) % mod);
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution552 solu = new Solution552();
        for (int i = 1; i < 10; i++) {
            System.out.println(solu.checkRecord(i));
        }
        System.out.println(solu.checkRecord(10101)); // 183236316
    }

}
