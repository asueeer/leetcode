package binary.devide;

import java.math.BigInteger;

/**
 * @author wangyisu
 */
public class Solution278 {
    public static class Solution extends VersionControl {
        public static int firstBadVersion(int n) {
            int lo = 0;
            int hi = n;
            int mid = 0;
            while((hi-lo)>=2){
//                mid = (lo+hi)/2; // 这样写（hi+lo）很大到时候，会导致溢出！！！！
                mid = lo + (hi-lo)/2;
                if(isBadVersion(mid)){
                    hi = mid;
                }else{
                    lo = mid;
                }
            }
            while(hi!=0){
                if(!isBadVersion(hi)){
                    return hi + 1;
                }
                hi--;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.firstBadVersion(2126753390));
    }
}
