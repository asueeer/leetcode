package tree;

/**
 * @author wangyisu
 */
public class Solution504 {
    // 看评论区里的，这个解法挺好的
    public String convertToBase7(int num) {
        if(num<0){
            return "-"+convertToBase7(-num);
        }
        if(num<7){
            return String.valueOf(num);
        }else{
            return convertToBase7(num/7) + String.valueOf(num%7);
        }
    }
}
