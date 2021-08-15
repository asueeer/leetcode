package string;

/**
 * @author wangyisu
 */
public class Solution12 {
    public static String intToRoman(int num) {
        int[] number = {1000,900,500,400,100,90,50,40,10,9,5,4,1} ;
        String[] s = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String temp = "";
        while(num!=0){
            for (int i = 0; i < number.length; i++) {
                if(num>=number[i]){
                    System.out.println(num);
                    num -= number[i];
                    temp+=s[i];
                    break;
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
