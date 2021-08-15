package stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author wangyisu
 */
public class Solution84 {
    // 可以用一个单调栈来找它的左边界和右边界！ 但我尝试了一下失败了！！ 这个是直接找左右边界的版本
    public static int largestRectangleArea(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = 1;
            int right = 1;
            while(true){
                if(i-left>=0 && heights[i-left]>=heights[i]){
                    left++;
                }
                if(i+right<=heights.length-1 && heights[i]<=heights[i+right]){
                    right++;
                }
                boolean continueCondition = (i-left>=0 && heights[i-left]>=heights[i]) || (i+right<=heights.length-1 && heights[i]<=heights[i+right]);
                if(!continueCondition){
                    break;
                }
            }
            area = Math.max(heights[i]*(right+left-1),area);
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println(largestRectangleArea(new int[]{0}));
        System.out.println(largestRectangleArea(new int[]{}));
        System.out.println(largestRectangleArea(new int[]{0,9}));
        System.out.println(largestRectangleArea(new int[]{2,1,2}));

        // nums是1000个1的数组
        int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 1;
        }
        System.out.println(largestRectangleArea(nums));
    }

}
