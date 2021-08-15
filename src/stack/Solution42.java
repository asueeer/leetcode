package stack;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author wangyisu
 */
public class Solution42 {
    public static int trap(int[] height) {
        LinkedList<Integer> arr = new LinkedList<Integer>();
        for (int i = 0; i < height.length; i++) {
            arr.add(height[i]);
        }
        int num = 0;
        while(!arr.isEmpty()){
            removeZeroOfEdge(arr);
            for (int i = 0; i < arr.size(); i++) {
                if(arr.get(i)==0){
                    num++;
                    arr.set(i, arr.get(i)+1);
                }
            }
            for (int i = 0; i < arr.size(); i++) {
                arr.set(i,arr.get(i)-1);
            }
        }
        return num;
    }

    public static void removeZeroOfEdge(LinkedList<Integer> arr){
        while((arr.size()>0)&&(arr.get(0)==0)){
            arr.remove(0);
        }
        while((arr.size()>0)&&(arr.get(arr.size()-1)==0)){
            arr.remove(arr.size()-1);
        }
    }

    public static void main(String[] args) {

    }
}
