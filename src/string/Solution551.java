package string;

public class Solution551 {
    public boolean checkRecord(String s) {
        int cntA = 0;
        int consecutiveL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (consecutiveL >= 3 || cntA >= 2) {
                return false;
            }
            if (s.charAt(i) == 'L') {
                consecutiveL++;
            } else {
                consecutiveL = 0;
            }
            if (s.charAt(i) == 'A') {
                cntA++;
            }
        }
        return consecutiveL < 3 && cntA < 2;
    }
}
