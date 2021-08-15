package recursion;

/**
 * @author wangyisu
 */
public class Josephus {
    public int lastRemaining(int n, int m) {
        if(n==1){
            return 0;
        }

        return ((m%n)+lastRemaining(n-1,m))%n;
    }
}
