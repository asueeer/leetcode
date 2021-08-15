package week;

import java.util.HashSet;

public class Solu {

    public static boolean flag = false;

    public static boolean exist(char[][] board, String word) {
        flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 当前点的位置为[i,j]
                // 从当前点出发，尝试走一条路径为word
                if (word.length() == 1) {
                    if (board[i][j] == word.charAt(0)) {
                        return true;
                    }
                }
                roam(board, i, j, word, "", new HashSet<>());
            }
        }
        return flag;
    }

    private static void roam(char[][] board, int i, int j, String word,
                             String path, HashSet<String> visited) {
        if (path.equals(word)) {
            flag = true;
            return;
        }
        if (flag) return;
        char cur = board[i][j];
        int cnt = path.length();
        if (cur != word.charAt(cnt)) return;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] direction : directions) {
            int nextI = i + direction[0];
            int nextJ = j + direction[1];
            if (nextI < 0 || nextI >= board.length) continue;
            if (nextJ < 0 || nextJ >= board[0].length) continue;
            String key = i + "," + j;
            if (visited.contains(key)) continue;
            HashSet<String> nextVisited = new HashSet<>(visited);
            nextVisited.add(key); // "1,1"
            roam(board, nextI, nextJ, word, path + cur, nextVisited);
        }
    }

    public static void main(String[] args) {
        String s = "";
        char a = 'a' - 97;
        System.out.println('a' - 97);
        System.out.println(a);
//        for (int i = 0; i < 26; i++) {
//            s += a;
//            a++;
//        }
//        a = 'A';
//        for (int i = 0; i < 26; i++) {
//            s += a;
//            a++;
//        }
//        System.out.println(s);
//        System.out.println(s.length());
    }
}
