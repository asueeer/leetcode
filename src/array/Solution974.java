package array;

/**
 * @author wangyisu
 */
public class Solution974 {
    public int subarraysDivByK(int[] A, int K) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum+=A[j];
                if(sum%K==0){
                    result++;
                }
            }
        }
        return result;
    }

    private int sum_(int[] A, int start, int end){  // [start,end)
        int result = 0;
        for (int i = start; i < end; i++) {
            result += A[i];
        }
        return result;
    }

    private boolean DivByK(int[] A, int a, int b, int k) {
        int sum = 0;
        for (int i = a; i < b; i++) {
            sum+=A[i];
        }
        return sum%k==0;
    }
    public static void main(String[] args) {
        Solution974 solu = new Solution974();
        System.out.println(solu.subarraysDivByK(new int[]{4,5,0,-2,-3,1}, 5));
    }
}
