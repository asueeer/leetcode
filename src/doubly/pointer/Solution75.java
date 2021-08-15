package doubly.pointer;

/**
 * @author wangyisu
 */
public class Solution75 {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int i = 0; i < nums.length; i++) {
            // j 从0到2，代表了三种颜色
            for (int j = 0; j < 3; j++) {
                if(nums[i]==j){
                    counts[j]++;
                    break;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 3; j++) {
                if(counts[j]>0){
                    nums[i] = j;
                    counts[j]--;
                    break;
                }
            }
        }
    }
}
