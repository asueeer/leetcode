package array;
import java.util.Random;

/**
 * @author wangyisu
 */
public class Solution287 {
    public static int findDuplicate(int[] nums) { // 快慢指针，等价于寻找环的入口
        int fast = nums[nums[0]];
        int slow = nums[0];
        while(fast!=slow){ // 寻找环
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        int thirdPointer = 0;
        while(thirdPointer!=slow){ // 找到环之后，使用第三个指针从头开始走，和慢指针一起一步一步走，相遇的地点就是环的入口
            thirdPointer = nums[thirdPointer];
            slow = nums[slow];
        }
        return slow;
    }

    public static int findDuplicate_(int[] nums) { // 快慢指针，等价于寻找环的入口
        int fast = nums[nums[0]];
        int slow = nums[0];
        while(!(fast!=slow && nums[fast]==nums[slow])){ // 寻找环
            Random r = new Random();
            //获取0-9之间的随机数
            int randomNumber = r.nextInt(2);
            if(randomNumber==1){
                fast = nums[fast];
            }else{
                fast = nums[nums[fast]];
            }
            slow = nums[slow];
        }
        return nums[fast];
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate_(new int[]{1,3,4,2,2}));
//        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findDuplicate_(new int[]{3,1,3,4,2}));
    }
}
