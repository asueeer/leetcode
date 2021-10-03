package week.be_week_62;

import java.util.HashMap;

public class Solution3 {
//
//    class Entry {
//        String ss;
//        int cnt;
//
//        public Entry(String ss, int cnt) {
//            this.ss = ss;
//            this.cnt = cnt;
//        }
//    }
//
//    public static String ss;
//    public static HashMap<String, Entry> record;
//    public static int ans;
//
//    public int maxConsecutiveAnswers(String answerKey, int k) {
//        ss = answerKey;
//        // ss 为最后的连续子串
//        // f(i, j) =  max{f(i - 1, j), f(i-1, j+1)}    if j < k
//        //            f(i - 1, j)    if j == k
//        //
//        if (answerKey.length() == 0) {
//            return 0;
//        }
//        record = new HashMap<>();
//        int[][] dp = new int[answerKey.length()][k];
//        dp[0][0] = 1;
//
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                if (i == 0 && j == 0) {
//                    dp[i][j] = 1;
//                    record.put(i + " " + j, new Entry(answerKey.substring(0, 1), 1));
//                    if (j != k) {
//                        dp[i][j + 1] = 1;
//                        record.put(i + " " + (j + 1), new Entry(reverseTheLast(answerKey.substring(0, 1)), 1));
//                    }
//                    continue;
//                }
//                if (j == k) {
//                    dp[i][j] = getAns(record, i - 1, j);
//                }
//                if (j != k) {
//                    dp[i][j] = Math.max(getAns(record, i - 1, j), getAns(record, i - 1, j + 1));
//                }
//            }
//        }
//
//        return dp[dp.length - 1][dp[0].length - 1];
//    }
//
//    public int getAns(HashMap<String, Entry> record, int i, int j) {
//        String key = i + " " + j;
//        Entry entry = record.get(key);
//
//        if (ss.charAt(i) == entry.ss.charAt(ss.length() - 1)) {
//            record.put(key, new Entry(entry.ss + ss.charAt(i), entry.cnt + 1));
//            return entry.cnt + 1;
//        }
//        record.put(key, new Entry("" + ss.charAt(i), 1));
//        return entry.cnt;
//    }
//
//    public String reverseTheLast(String s) {
//        char c = s.charAt(s.length() - 1);
//        if (c == 'T') {
//            c = 'F';
//        }
//        if (c == 'F') {
//            c = 'T';
//        }
//        return s.substring(0, s.length() - 1) + c;
//    }
//
//    public static void main(String[] args) {
//
//    }
}
