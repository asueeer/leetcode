package dfs;

import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution576 {
    // 首先 有一个 起始点 Point [startRow, startColumn]
    // 初始化一个map，记录<状态，答案>
    // 如果这个状态在map里有记录，返回map里的值

    // 如果没有记录的话，
    // 情形1 ： 已经出界了，答案是1
    // 情形2 ： 在网格的里面，答案就是[point向上的答案] + [point向下的答案] + [point向左的答案] + [point向右的答案],
    //         （剩余的移动次数会减一）

    // 将答案放到map里
    // 最终返回答案。

    int m;
    int n;

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isOut() {
            if (x < 0 || y < 0) {
                return true;
            }
            return x >= m || y >= n;
        }

        public List<Point> nextMoves() {
            List<Point> ret = new ArrayList<>();
            ret.add(new Point(x + 1, y));
            ret.add(new Point(x - 1, y));
            ret.add(new Point(x, y + 1));
            ret.add(new Point(x, y - 1));
            return ret;
        }
    }

    HashMap<String, Integer> record = new HashMap<>();
    long mod = (long) (1e9 + 7);

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        record.clear();
        Point point = new Point(startRow, startColumn);

        return bfs(point, maxMove);
    }

    private int bfs(Point cur, int leftMove) { // cur是当前所处的节点，leftMove剩余可移动的次数
        int ans = 0;
        String key = cur.x + " " + cur.y + " " + leftMove;
        if (record.containsKey(key)) {
            return record.get(key);
        }

        if (cur.isOut()) {
            record.put(key, 1);
            return 1;
        }

        if (leftMove == 0) {
            return 0;
        }
        List<Point> nextMoves = cur.nextMoves();
        for (Point nextMove : nextMoves) {
            ans = (int) ((ans + bfs(nextMove, leftMove - 1)) % mod);
        }
        record.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        // m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
        // 输出：6
        Solution576 solu = new Solution576();
        System.out.println(solu.findPaths(2, 2, 2, 0, 0));

//        m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//        输出：12
        System.out.println(solu.findPaths(1, 3, 3, 0, 1));
    }
}
