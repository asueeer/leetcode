package hashmap;

/**
 * @author wangyisu
 */
public class Solution202 {
    public static boolean isHappy(int n) {
        int record = 0;
        while(n!=1){
            String num = String.valueOf(n);
            System.out.println(num);
            n = 0;
            for (int i = 0; i < num.length(); i++) {
                int temp = Integer.parseInt(num.substring(i,i+1));
                n+=temp*temp;
            }
            record++;
            if(record>5000){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Solution202.isHappy(19));
    }
}
