package hashmap;

import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Collections.sort;

/**
 * @author wangyisu
 */
public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        ArrayList<Integer> kids = new ArrayList<>();
        ArrayList<Integer> food = new ArrayList<>();
        for (int i : g) {
            kids.add(i);
        }
        for (int i : s) {
            food.add(i);
        }
        sort(kids);
        sort(food);
        for (int i = 0; i < food.size(); i++) {
            if(kids.isEmpty()){
                break;
            }
            int foodCapacity = food.get(i);
//            System.out.println(foodCapacity);
            // 调用popKid函数，popKid函数的功能是
            // 1 如果不能满足，返回int最大值 2 如果能满足，返回能满足的孩子的容量，并且将该kid在kids中删除
            if(kids.get(0)<=foodCapacity){
                result++;
                kids.remove(0);
            }
        }
        return result;
    }

    public int popKid(int foodCapacity, ArrayList<Integer> kids){
        System.out.println(kids);
        if(kids.isEmpty() || kids.get(0)>foodCapacity){
            return Integer.MAX_VALUE;
        }else{
            return kids.remove(0); // 将kids中第0个元素删除，并且将被删除的元素返回
        }
    }

    public static void main(String[] args) {
        Solution455 solu = new Solution455();
//        System.out.println(solu.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(solu.findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,7,8}));
    }
}
