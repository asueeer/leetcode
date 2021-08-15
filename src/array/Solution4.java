package array;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author wangyisu
 */
public class Solution4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            lst.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            lst.add(nums2[i]);
        }
        lst.sort(Comparator.comparing(Integer::intValue));
        if(lst.size()%2==0){
            return (lst.get(lst.size()/2-1) + lst.get(lst.size()/2))/2;
        }else{
            return lst.get((lst.size()+1)/2-1);
        }
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = array[i];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        swap(nums,1,2);
        System.out.println(nums[1]);
//        int[] nums2 = new int[]{5,23,34,45};
//
//        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
