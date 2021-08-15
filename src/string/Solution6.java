package string;

import java.util.ArrayList;

/**
 * @author wangyisu
 */
public class Solution6 {
    public static String convert(String s, int numRows) {
        if((numRows*2-2)==0){
            return s;
        }
        String temp = new String();
        ArrayList<String> strs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            temp+=s.charAt(i);
            if(temp.length()%(numRows*2-2)==0){
                strs.add(temp);
                temp = "";
            }
        }
        if(temp.length()!=0){
            for (int i = temp.length(); i < numRows*2-2; i++) {
                temp+="&";
            }
            strs.add(temp);
        }
        System.out.println(strs);
        temp = "";
        int index = numRows*2 - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < strs.size(); j++) {
                temp += strs.get(j).charAt(i);
                if(i>=1 && i<=numRows-2){
                    temp += strs.get(j).charAt(index);
                }
            }
            index--;
        }
        String result = "";
        for (int i = 0; i < temp.length(); i++) {
            if(temp.charAt(i)!='&'){
                result+=temp.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING",3));
        System.out.println(convert("LEETCODEISHIRING",3));
        System.out.println("LCIRETOESIIGEDHN");
        System.out.println(convert("A",1));
        System.out.println(convert("AB",1));
    }
}
