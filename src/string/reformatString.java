package string;

/**
 * @author wangyisu
 */
public class reformatString {
    public static String reformat(String s){
        String new_s = new String();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='['){
                new_s+="{";
            }else if(s.charAt(i)==']'){
                new_s+="}";
            }else {
                new_s+=String.valueOf(s.charAt(i));
            }
        }
        return new_s;
    }

    public static void main(String[] args) {
        System.out.println(reformat("[\n" +
                " [ 1, 2, 3 ],\n" +
                " [ 4, 5, 6 ],\n" +
                " [ 7, 8, 9 ]\n" +
                "]"));

        System.out.println(reformat("[[0,1],[1,0]]"));
        System.out.println(reformat("[[0,0,0],[1,1,0],[1,1,0]]"));
        System.out.println(reformat("[[0,0,0],[1,0,0],[1,1,0]]\n"));

        System.out.println(reformat("[[1,1,1],[1,1,0],[1,0,1]]"));
    }
}
