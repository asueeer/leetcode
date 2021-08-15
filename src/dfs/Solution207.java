package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author wangyisu
 */
public class Solution207 {
    public class Node{
        public Node(int num) {
            this.num = num;
        }
        public int num;
        public ArrayList<Integer> lst = new ArrayList<>();
    }
    public static boolean haveLoop;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] courses = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Node(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            courses[prerequisites[i][0]].lst.add(prerequisites[i][1]);
        }
        haveLoop = false;
        HashSet<Integer> visited;
        for (int i = 0; i < courses.length; i++) {
            visited = new HashSet<>();
            visited.add(i);
            dfs(courses, i, visited);
        }
        return !haveLoop;
    }

    private void dfs(Node[] courses, int i, HashSet<Integer> visited) {
        if(haveLoop){
            return;
        }
        ArrayList<Integer> nexts = courses[i].lst;
        for (int j = 0; j < nexts.size(); j++) {
            if(visited.contains(nexts.get(j))){
                haveLoop = true;
            }else{
                visited.add(nexts.get(j));
                dfs(courses, nexts.get(j), visited);
            }
            visited.remove(nexts.get(j));
        }
    }
}
