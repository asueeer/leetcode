package binary.devide;

import java.math.BigDecimal;

/**
 * @author wangyisu
 */
public class Solution29 {
    public static int divide(int dividend, int divisor) {
        BigDecimal dividend_ = new BigDecimal(dividend);
        BigDecimal divisor_ = new BigDecimal(divisor);
        if(dividend_.divideToIntegralValue(divisor_).equals(new BigDecimal("2147483648"))){
            System.out.println("True");
            return 2147483647;
        }
        return dividend_.divideToIntegralValue(divisor_).intValue();
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648,-1));
    }
}
