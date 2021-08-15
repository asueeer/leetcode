package stack;

import java.util.Stack;

/**
 * @author wangyisu
 */
public class Solution224 {
    public int calculate(String s) {
        Stack<String> st = new Stack<>();
        int i = 0;
        int result = 0;
        while(i<s.length()){
//            System.out.println(st);
            if(s.charAt(i)==' '){
                i++;
                continue;
            }
            if(s.charAt(i)=='('){
                st.push("(");
                i++;
            }else if(s.charAt(i)==')'){
                // 两个两个向外弹
                int cur = 0;
                while(true){
                    String digitStr = st.pop();
                    String nonDigitStr = st.pop();
                    if(nonDigitStr.equals("+")){
                        cur+=Integer.parseInt(digitStr);
                    }else if(nonDigitStr.equals("-")){
                        cur-=Integer.parseInt(digitStr);
                    }else if(nonDigitStr.equals("(")){
                        cur+=Integer.parseInt(digitStr);
                        st.push(String.valueOf(cur));
                        break;
                    }
                }
                i++;
            }else if(s.charAt(i)=='+' || s.charAt(i)=='-'){
                st.push(String.valueOf(s.charAt(i)));
                i++;
            }else{
                int j = i;
                while(j<s.length() && Character.isDigit(s.charAt(j))){
                    j++;
                }
                st.push(s.substring(i,j));
//                System.out.println(st);
                i = j;
            }
        }
        // 清空栈
        while(true){
            String digitStr = st.pop();
            if(st.empty()){
                result+=Integer.parseInt(digitStr);
                break;
            }
            String nonDigitStr = st.pop();
            if(nonDigitStr.equals("+")){
                result+=Integer.parseInt(digitStr);
            }else if(nonDigitStr.equals("-")){
                result-=Integer.parseInt(digitStr);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution224 solu = new Solution224();
        System.out.println(solu.calculate("1+1"));
    }
}
