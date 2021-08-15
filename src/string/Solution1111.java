package string;

/**
 * @author wangyisu
 */
public class Solution1111 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        boolean belongToZero_LeftP = true;
        boolean belongToZero_RightP = true;
        for (int i = 0; i < seq.length(); i++) {
            char ch = seq.charAt(i);
            if(ch=='('){
                result[i] = zeroOrOne(belongToZero_LeftP);
                belongToZero_LeftP = !belongToZero_LeftP;
            }else{
                result[i] = zeroOrOne(belongToZero_RightP);
                belongToZero_RightP = !belongToZero_RightP;
            }
        }
        return result;
    }

    private int zeroOrOne(boolean belongToZero) {
        if(belongToZero){
            return 0;
        }else{
            return 1;
        }
    }
}
