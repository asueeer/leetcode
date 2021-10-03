package week.be_week_62;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution3_2 {

    class State {
        String answer;
        int cnt;

        public State(String answer, int cnt) {
            this.answer = answer;
            this.cnt = cnt;
        }

        public ArrayList<State> generate(char c) {
            ArrayList<State> states = new ArrayList<>();
            if (answer.charAt(answer.length() - 1) == c) {
                states.add(new State(answer + c, cnt));
                if (cnt < k) {
                    State state2 = new State("" + reverse(c), cnt + 1);
                    states.add(state2);
                }
                return states;
            }

            State state1 = new State("" + c, cnt);
            states.add(state1);

            if (cnt < k) {
                State state2 = new State(answer + reverse(c), cnt + 1);
                states.add(state2);
            }
            return states;
        }

        @Override
        public String toString() {
            return "State{" +
                    "answer='" + answer + '\'' +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    public static char reverse(char c) {
        if (c == 'T') {
            return 'F';
        }
        return 'T';
    }

    public int ans = Integer.MIN_VALUE;
    public int k = 0;

    public HashMap<String, Integer> record = new HashMap<>();

    public int maxConsecutiveAnswers(String answerKey, int k) {
        this.k = k;
        record = new HashMap<>();
        recurse(answerKey, k);
        return ans;
    }

    public ArrayList<State> recurse(String ss, int k) {
        ArrayList<State> ret = new ArrayList<>();
        if (ss.length() == 0) {
            ret.add(new State("", 0));
            ans = Math.max(ans, 0);
            return ret;
        }
        if (ss.length() == 1) {
            if (k != 0) {
                State state1 = new State(reverseTheLast(ss), 1);
                ret.add(state1);
            }
            State state2 = new State(ss, 0);
            ret.add(state2);
            ans = Math.max(ans, 1);
            return ret;
        }
        ArrayList<State> states = recurse(ss.substring(0, ss.length() - 1), k);
//        System.out.println(ss.charAt(ss.length() - 1));
//        System.out.println(states);

        for (State state : states) {
            ArrayList<State> gStates = state.generate(ss.charAt(ss.length() - 1));
            for (State gState : gStates) {
                ans = Math.max(ans, gState.answer.length());
                if (record.containsKey(gState.answer)) {
                    if (record.get(gState.answer) < gState.cnt) {
                        continue;
                    }
                }

                record.put(gState.answer, gState.cnt);
                ret.add(gState);
            }
            record.clear();
        }
//        System.out.println(ret);
//        System.out.println();
        return ret;
    }

    public static String reverseTheLast(String s) {
        char c = s.charAt(s.length() - 1);
        if (c == 'T') {
            c = 'F';
        } else {
            c = 'T';
        }
        return s.substring(0, s.length() - 1) + c;
    }

    public static void main(String[] args) {
        Solution3_2 solu = new Solution3_2();
//        System.out.println(solu.maxConsecutiveAnswers("TTFF", 2));
//        System.out.println(solu.maxConsecutiveAnswers("TFFT", 1));
//        System.out.println(solu.maxConsecutiveAnswers("TTFTTFTT", 1));
        System.out.println(solu.maxConsecutiveAnswers(
                "FTFFTFTFTTFTTFTTFFTTFFTTTTTFTTTFTFFTTFFFFFTTTTFTTTTTTTTTFTTFFTTFTFFTTTFFFFFTTTFFTTTTFTFTFFTTFTTTTTTF"
                , 32));
    }
}
