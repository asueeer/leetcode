package sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wangyisu
 */
public class Solution912 {
    private static int partition(int[] nums, int lo, int hi) {
        int start = lo;
        int end = hi;
        int pivot = nums[lo];
        while(true){
            while(nums[start]<=pivot){
                start++;
                if(start>end){
                    break;
                }
            }
            while(nums[end]>=pivot){
                end--;
                if(start>end){
                    break;
                }
            }
            if(start>end){
                break;
            }
            swap(nums,start,end);
        }
        swap(nums,lo,end);
        return end;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if(hi<=lo){
            return;
        }
        int mi = partition(nums,lo,hi);
        quickSort(nums,lo,mi-1);
        quickSort(nums,mi+1,hi);
    }

    public static List<Integer> sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        List<Integer> result = new ArrayList<>();
        for(Integer i : nums){
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{35,23,3,1,221,12,3323,3,2,32,2,3,1,12};
        sortArray(nums);
//        partition(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(',');
        }
    }
}
