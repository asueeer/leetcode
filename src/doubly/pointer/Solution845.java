package doubly.pointer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution845 {
    public int longestMountain(int[] A) {
        HashSet<Integer> possibleAns = new HashSet<>();
        int result = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                possibleAns.add(i);
            }
        }

        for (Integer i : possibleAns) {
            int leftPointer = i - 1;
            int rightPointer = i + 1;
            while (leftPointer > -1 && A[leftPointer] < A[leftPointer + 1]) {
                leftPointer--;
            }
            while (rightPointer < A.length && A[rightPointer] < A[rightPointer - 1]) {
                rightPointer++;
            }
            result = Math.max(result, rightPointer - leftPointer - 1);
        }
        return result;
    }

    @Test
    public void test() {
        Solution845 solu = new Solution845();
        int result = solu.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5});
        assertEquals(5,  result);
        result = solu.longestMountain(new int[]{2,2,2});
        assertEquals(0,  result);
        result = solu.longestMountain(new int[]{0,1,2,3,4,5,4,3,2,1,0});
        assertEquals(11,  result);
    }
}
