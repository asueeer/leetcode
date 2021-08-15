package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution279 {
    public int numSquares(int n) {
        HashMap<Integer, Integer> record = new HashMap<>();
        record.put(0, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int i = 0;
            while (i * i + node <= n) {
                int key = i * i + node;
                if (!record.containsKey(key)) {
                    queue.offer(key);
                    record.put(key, record.get(node) + 1);
                }
                if (key == n) {
                    return record.get(n);
                }
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution279 solu = new Solution279();
        System.out.println(solu.numSquares(12));
    }
}
