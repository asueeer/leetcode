package week.contest222;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1 {
//    public int maximumUnits(int[][] boxTypes, int truckSize) {
//        for (int i = 0; i < boxTypes.length; i++) {
//            for (int j = 0; j < boxTypes.length; j++) {
//                if (boxTypes[i][1] > boxTypes[j][1]) {
//                    int[] temp = boxTypes[i];
//                    boxTypes[i] = boxTypes[j];
//                    boxTypes[j] = temp;
//                }
//            }
//        }
//        System.out.println(Arrays.deepToString(boxTypes));
//        int result = 0;
//        for (int[] boxType : boxTypes) {
//            if (truckSize >= boxType[0]) {
//                result += boxType[0] * boxType[1];
//                truckSize -= boxType[0];
//            } else {
//                result += boxType[1] * truckSize;
//                break;
//            }
//        }
//        return result;
//    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t2[1] - t1[1];
            }
        });
        int ret = 0;
        for (int[] boxType : boxTypes) {
            int num = Math.min(boxType[0], truckSize);
            ret += num * boxType[1];
            truckSize -= num;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        // [[1,3],[2,2],[3,1]], 4
//        System.out.println(solu.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
//        [[5,10],[2,5],[4,7],[3,9]]
//        10
        System.out.println(solu.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
    }
}
