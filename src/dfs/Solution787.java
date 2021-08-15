package dfs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wangyisu
 */
public class Solution787 {
    public class Node{
        public int num;
        public ArrayList<ArrayList<Integer>> nexts;
        public Node(int num) {
            this.num = num;
            nexts = new ArrayList<>();
        }
    }
    int result = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] flight : flights) {
            ArrayList<Integer> lst = new ArrayList<>();
            lst.add(flight[1]); // 下一站
            lst.add(flight[2]); // 所需花费
            nodes[flight[0]].nexts.add(lst);
        }
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[i].nexts);
        }
        dfs(src, dst, K, nodes, -1, 0);
        if(result==Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }

    private void dfs(int src, int dst, int k, Node[] nodes, int visited, int cost) {
        if(cost>result){
            return;
        }
        if(visited>k){
            return;
        }
        if(src==dst){
            if(cost<result){
                result = cost;
            }
        }
        ArrayList<ArrayList<Integer>> nexts = nodes[src].nexts;
        for (ArrayList<Integer> next : nexts) {
            dfs(next.get(0), dst, k, nodes, visited+1, cost+next.get(1));
        }
    }

    public static void main(String[] args) {
        Solution787 solu = new Solution787();
        System.out.println(solu.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
    }
}
