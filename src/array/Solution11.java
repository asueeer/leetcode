package array;

/**
 * @author wangyisu
 */
public class Solution11 {
    public static int maxArea(int[] height) {
        int max_ = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int Volume = Math.min(height[i],height[j])*(j-i);
                max_ = Math.max(Volume,max_);
            }
        }
        return max_;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
