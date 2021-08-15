package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wangyisu
 */
public class SolutionJ21 {
    public int[] exchange(int [] nums) {
        ArrayList<Integer> oddNums = new ArrayList<>();
        ArrayList<Integer> evenNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==1){
                oddNums.add(nums[i]);
            }else{
                evenNums.add(nums[i]);
            }
        }
        System.out.println(oddNums);
        System.out.println(evenNums);
        for (int i = 0; i < oddNums.size(); i++) {
            nums[i] = oddNums.get(i);
        }
        for (int i = oddNums.size(), j=0; j < evenNums.size(); i++,j++) {
            nums[i] = evenNums.get(j);
        }
        return nums;
    }
    public void reOrderArray(int[] array) {
        int i = 0;
        int j = array.length -1;
        while(i<=j){
            while(array[i]%2==1){
                i++;
            }
            while(array[j]%2 ==0){
                j--;
            }
            if(i<j){
                swap(array,i,j);
            }
        }
    }


    public void swap(int [] array,int i, int j){
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        SolutionJ21 solu = new SolutionJ21();
        int[] arr = new int[]{1,2,3,4};
        solu.reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
