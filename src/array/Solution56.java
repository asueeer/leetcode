package array;

import java.util.Arrays;

public class Solution56 {
    // 1. 首先看输入的任意两个间隔有没有重叠
    // 2. 如果有，合并
    // 3. 如果没有，返回合并之后的结果
    public static int[][] merge(int[][] intervals) {
        // write your code here
        boolean overlapped = true; // 有罪推定，intervals区间有重叠
        while (overlapped) {
            overlapped = false;
            for (int i = 0; i < intervals.length; i++) {
                for (int j = i + 1; j < intervals.length; j++) {
//                intervals[i] and intervals[j]
                    if (overlap(intervals[i], intervals[j])) {
//                    System.out.println(Arrays.toString(intervals[i]));
//                    System.out.println(Arrays.toString(intervals[j]));
//                    System.out.println("重叠...");
//                    System.out.println();
                        intervals[i] = mergedInterval(intervals[i], intervals[j]);
                        intervals = remove(intervals, j);
                        overlapped = true;
                        break;
                    }
                }
                if (overlapped) {
                    break;
                }
            }
        }
        return intervals;
    }

    private static int[][] remove(int[][] intervals, int j) {
        int[][] result = new int[intervals.length - 1][2];
        // 从[0,j-1] [j+1, intervals.length - 1]
        for (int i = 0; i <= j - 1; i++) {
            result[i] = intervals[i];
        }
        for (int i = j + 1; i <= intervals.length - 1; i++) {
            result[i - 1] = intervals[i];
        }
        return result;
    }

    private static int[] mergedInterval(int[] interval1, int[] interval2) {
        // 2个区间，4个端点
        // 取最小值作为左端点，取最大值作为右端点
        int min = Math.min(interval1[0], interval2[0]);
        int max = Math.max(interval1[1], interval2[1]);
        return new int[]{min, max};
    }

    private static boolean overlap(int[] interval1, int[] interval2) {
        // if interval1[0]<= interval2[0] <=interval1[1]
        // or interval1[0]<= interval2[1] <=interval1[1]
        //     return true
        // else:
        // if interval2[0]<= interval1[0] <=interval2[1]
        // or interval2[0]<= interval1[1] <=interval2[1]
        //     return true
        // else:
        //     return false

        // 以interval1作为基准，判断interval2的左右端点是否在interval1这个区间里面
        if (isIn(interval1, interval2[0]) || isIn(interval1, interval2[1])) {
            return true;
        }
        // 以interval2作为基准，判断interval1的左右端点是否在interval1这个区间里面
        return isIn(interval2, interval1[0]) || isIn(interval2, interval1[1]);
    }

    private static boolean isIn(int[] interval1, int i) {
        return i >= interval1[0] && i <= interval1[1];
    }

    public static void main(String[] args) {
//        输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//        输出: [[1,6],[8,10],[15,18]]
//        解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
        int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(input)));
        System.out.println();
        input = new int[][]{{1, 4}, {4, 5}};
        System.out.println(Arrays.deepToString(merge(input)));
    }
}
