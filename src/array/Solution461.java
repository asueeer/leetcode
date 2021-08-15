package array;

/**
 * @author wangyisu
 */
public class Solution461 {
    public int hammingDistance(int x, int y) {
        String s = Integer.toBinaryString(x^y);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution461 solu = new Solution461();
        System.out.println(solu.hammingDistance(1,4));
    }
}
