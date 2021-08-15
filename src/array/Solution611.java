package array;

import java.util.ArrayList;
import static java.util.Arrays.sort;

/**
 * @author wangyisu
 */
public class Solution611 {
    public int triangleNumber(int[] nums) {
        int count = 0;
        sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[k]<nums[i]+nums[j]){
                        count++;
                    }else{
                        break;
                    }
                }
            }
        }
        return count;
    }

    private boolean isTriangle(ArrayList<Integer> combines) {
        if(combines.size()!=3){
            return false;
        }
        int a = combines.get(0);
        int b = combines.get(1);
        int c = combines.get(2);
        if(a+b<=c){
            return false;
        }
        return true;
    }

    private ArrayList<ArrayList<Integer>> anyThreeNums(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int[] combine = new int[]{nums[i],nums[j],nums[k]};
                    sort(combine);
                    ArrayList<Integer> lst = new ArrayList<>();
                    for (int l = 0; l < combine.length; l++) {
                        lst.add(combine[l]);
                    }
                    result.add(lst);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution611 solu = new Solution611();
        System.out.println(solu.triangleNumber(new int[]{2,2,3,4}));
    }
}
