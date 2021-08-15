package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution576 {
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

        public Point up() {
            return new Point(x, y - 1);
        }

        public Point down() {
            return new Point(x, y + 1);
        }

        public Point left() {
            return new Point(x - 1, y);
        }

        public Point right() {
            return new Point(x + 1, y);
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }

    class State {
        Point curPos;
        int leftMove;

        public State(Point curPos, int leftMove) {
            this.curPos = curPos;
            this.leftMove = leftMove;
        }

        boolean isOut() {
            return curPos.isOut();
        }

        boolean hasChance() {
            boolean couldOut = false;
            if (curPos.x - leftMove < 0 || curPos.y - leftMove < 0) {
                couldOut = true;
            }
            if (curPos.x + leftMove >= m || curPos.y + leftMove >= n) {
                couldOut = true;
            }
            return couldOut;
        }

        boolean hasNoMove() {
            return leftMove <= 0;
        }

        public ArrayList<State> move() {
            ArrayList<State> ret = new ArrayList<>();
            if (hasNoMove()) {
                return ret;
            }
            ret.add(new State(curPos.up(), leftMove - 1));
            ret.add(new State(curPos.down(), leftMove - 1));
            ret.add(new State(curPos.left(), leftMove - 1));
            ret.add(new State(curPos.right(), leftMove - 1));
            return ret;
        }

        @Override
        public String toString() {
            return "State{" +
                    "curPos=" + curPos +
                    ", leftMove=" + leftMove +
                    '}';
        }
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        long cnt = 0;
        Point p = new Point(startRow, startColumn);
        Queue<State> que = new LinkedList<>();
        que.add(new State(p, maxMove));
        while (!que.isEmpty()) {
            State state = que.poll();
            if (!state.hasChance()) {
                continue;
            }
            if (state.isOut()) {
                cnt++;
                continue;
            }
            ArrayList<State> nextMoves = state.move();
            que.addAll(nextMoves);
        }
        return (int) (cnt % (1e9 + 7));
    }


    public static void main(String[] args) {
        Solution576 solu = new Solution576();
        // m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
        // 6
        System.out.println(solu.findPaths(2, 2, 2, 0, 0));

        // 0
        System.out.println(solu.findPaths(3, 8, 0, 2, 0));

        System.out.println(solu.findPaths(10, 10, 11, 5, 5));

        System.out.println(solu.findPaths(7, 6, 13, 0, 2));
    }

}
