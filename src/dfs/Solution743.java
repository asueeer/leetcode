package dfs;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author wangyisu
 */
public class Solution743 {
    public class Node{
        public int num;
        public ArrayList<ArrayList<Integer>> nexts;
        public Node(int num) {
            this.num = num;
            nexts = new ArrayList<>();
        }
    }
    HashMap<Integer, Integer> result = new HashMap<>();
    public int networkDelayTime(int[][] times, int N, int K) {
        Node[] nodes = new Node[N+1];
        for (int i = 0; i < N+1; i++) {
            nodes[i] = new Node(i+1);
        }
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            ArrayList<Integer> next = new ArrayList<>();
            next.add(v);
            next.add(w);
            nodes[u].nexts.add(next);
        }
        dfs(K, nodes, 0);
        if(result.size()!=N){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        for(Integer value:result.values()) {
            max = Math.max(value, max);
        }
        return max;
    }

    private void dfs(int k, Node[] nodes, int time) {
        if(!result.containsKey(k)){
            result.put(k, time);
        }else{
            if(result.get(k)<=time){
                return;
            }else{
                result.put(k,time);
            }
        }
        ArrayList<ArrayList<Integer>> lst = nodes[k].nexts;
        for (int i = 0; i < lst.size(); i++) {
            ArrayList<Integer> next = lst.get(i);
            time+=next.get(1);
            dfs(next.get(0), nodes, time);
            time-=next.get(1);
        }
    }

    private String replaceChar(String s){
        String newString = "";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='['){
                newString+="{";
            }else if(s.charAt(i)==']'){
                newString+="}";
            }else{
                newString+=s.charAt(i);
            }
        }
        return newString;
    }

    public static void main(String[] args) {
        Solution743 solu = new Solution743();
//        times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
//        System.out.println(solu.replaceChar(" [[2,1,1],[2,3,1],[3,4,1]]"));
        System.out.println(solu.networkDelayTime(new int[][] {{2,1,1},{2,3,1},{3,4,1}},4,2));
        System.out.println(solu.replaceChar("[[0,199],[1,198],[2,197],[3,196],[4,195],[5,194],[6,193],[7,192],[8,191],[9,190],[10,189],[11,188],[12,187],[13,186],[14,185],[15,184],[16,183],[17,182],[18,181],[19,180],[20,179],[21,178],[22,177],[23,176],[24,175],[25,174],[26,173],[27,172],[28,171],[29,170],[30,169],[31,168],[32,167],[33,166],[34,165],[35,164],[36,163],[37,162],[38,161],[39,160],[40,159],[41,158],[42,157],[43,156],[44,155],[45,154],[46,153],[47,152],[48,151],[49,150],[50,149],[51,148],[52,147],[53,146],[54,145],[55,144],[56,143],[57,142],[58,141],[59,140],[60,139],[61,138],[62,137],[63,136],[64,135],[65,134],[66,133],[67,132],[68,131],[69,130],[70,129],[71,128],[72,127],[73,126],[74,125],[75,124],[76,123],[77,122],[78,121],[79,120],[80,119],[81,118],[82,117],[83,116],[84,115],[85,114],[86,113],[87,112],[88,111],[89,110],[90,109],[91,108],[92,107],[93,106],[94,105],[95,104],[96,103],[97,102],[98,101],[99,100],[100,99],[101,98],[102,97],[103,96],[104,95],[105,94],[106,93],[107,92],[108,91],[109,90],[110,89],[111,88],[112,87],[113,86],[114,85],[115,84],[116,83],[117,82],[118,81],[119,80],[120,79],[121,78],[122,77],[123,76],[124,75],[125,74],[126,73],[127,72],[128,71],[129,70],[130,69],[131,68],[132,67],[133,66],[134,65],[135,64],[136,63],[137,62],[138,61],[139,60],[140,59],[141,58],[142,57],[143,56],[144,55],[145,54],[146,53],[147,52],[148,51],[149,50],[150,49],[151,48],[152,47],[153,46],[154,45],[155,44],[156,43],[157,42],[158,41],[159,40],[160,39],[161,38],[162,37],[163,36],[164,35],[165,34],[166,33],[167,32],[168,31],[169,30],[170,29],[171,28],[172,27],[173,26],[174,25],[175,24],[176,23],[177,22],[178,21],[179,20],[180,19],[181,18],[182,17],[183,16],[184,15],[185,14],[186,13],[187,12],[188,11],[189,10],[190,9],[191,8],[192,7],[193,6],[194,5],[195,4],[196,3],[197,2],[198,1],[199,0]]\n" +
                "[0,0]\n" +
                "[200,200]"));
    }
}
