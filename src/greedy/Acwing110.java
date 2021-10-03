package greedy;

import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Acwing110 {
    public int maxSPFCount(int[] minSPF, int[] maxSPF, int[] covers, int[] SPF) {
        // 对奶牛进行排序 从大到小
        int C = minSPF.length;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < C; j++) {
                if (minSPF[i] > minSPF[j]) {
                    int temp = minSPF[i];
                    minSPF[i] = minSPF[j];
                    minSPF[j] = temp;

                    temp = maxSPF[i];
                    maxSPF[i] = maxSPF[j];
                    maxSPF[j] = temp;
                }
            }
        }
        // 对SPF进行排序
        int L = SPF.length;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                if (SPF[i] > SPF[j]) {
                    int temp = SPF[i];
                    SPF[i] = SPF[j];
                    SPF[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(minSPF));
        System.out.println(Arrays.toString(maxSPF));
        System.out.println(Arrays.toString(SPF));
        // 对每一瓶防晒霜进行遍历
        // 防晒霜tab
        // 0 [1, 2]
        // 1 [3, 4]
        HashMap<Integer, HashSet<Integer>> coverRecord = new HashMap<>();
        // 0 [0, 1]
        HashMap<Integer, HashSet<Integer>> cowRecord = new HashMap<>();


        for (int i = 0; i < C; i++) {
            cowRecord.put(i, new HashSet<>());
        }
        for (int cover = 0; cover < covers.length; cover++) {
            coverRecord.put(cover, new HashSet<>());
            for (int cow = 0; cow < C; cow++) {
                if (SPF[cover] >= minSPF[cow] && SPF[cover] <= maxSPF[cow]) {
                    coverRecord.get(cover).add(cow);
                    cowRecord.get(cow).add(cover);
                }
            }
        }
        System.out.println("coverRecord: " + coverRecord);
        System.out.println("cowRecord: " + cowRecord);
        int cnt = 0;
        for (int cow = 0; cow < C; cow++) {
            // 找到最合适的防晒霜
            int theFitCover = -1;
            int minFitCnt = Integer.MAX_VALUE;
            for (Integer cover : cowRecord.get(cow)) {
                if (covers[cover] == 0) {
                    continue;
                }
                int size = covers[cover];
                if (size < minFitCnt) {
                    minFitCnt = size;
                    theFitCover = cover;
                }
            }
            if (theFitCover == -1 || covers[theFitCover] == 0) {
                // 未找到合适的防晒霜
                continue;
            }
            System.out.println("第" + cow + "头奶牛用了第" + theFitCover + "瓶防晒霜");
            covers[theFitCover]--;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
//        Acwing110 solu = new Acwing110();
//        int[] minSPF = new int[]{1, 1, 1};
//        int[] maxSPF = new int[]{5, 2, 2};
//        int C = minSPF.length;
//        int[] cover = new int[]{2, 1, 1, 10};
//        int L = cover.length;
//
//        int[] SPF = new int[]{2, 4, 3, 6};
//        System.out.println(solu.maxSPFCount(minSPF, maxSPF, cover, SPF)); // 3
//
//        Acwing110 solu = new Acwing110();
//        int[] minSPF = new int[]{1, 5, 1};
//        int[] maxSPF = new int[]{5, 8, 2};
//        int C = minSPF.length;
//        int[] cover = new int[]{1, 1, 1, 10};
//        int L = cover.length;
//
//        int[] SPF = new int[]{1, 4, 3, 6};
//        System.out.println(solu.maxSPFCount(minSPF, maxSPF, cover, SPF)); // 2

        Acwing110 solu = new Acwing110();
        int[] minSPF = new int[]{2, 1, 3, 1, 2};
        int[] maxSPF = new int[]{10, 2, 30, 5, 3};
        int[] cover = new int[]{2, 2, 1};
        int[] SPF = new int[]{2, 10, 30};
        System.out.println(solu.maxSPFCount(minSPF, maxSPF, cover, SPF)); // 4
    }
}
