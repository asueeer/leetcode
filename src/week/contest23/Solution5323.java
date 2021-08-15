package week.contest23;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.util.Arrays.sort;

/**
 * @author wangyisu
 */
public class Solution5323 {
    public static int maxSatisfaction(int[] satisfaction) {
        sort(satisfaction);
        ArrayList<Integer> results = new ArrayList<>();
        ArrayList<Integer> satisfactions = new ArrayList<>();
        for (int i = 0; i < satisfaction.length; i++) {
            satisfactions.add(satisfaction[i]);
        }
        int pre = 0;
        for (int i = satisfactions.size()-1; i > -1; i--) {
            int v = compute(satisfactions, i);
            if(v>pre){
                pre = v;
            }else{
                break;
            }
        }

        return pre;
    }

    private static int compute(ArrayList<Integer> satisfactions, int i) {
        int index = 1;
        int result = 0;
        for (int j = i; j < satisfactions.size(); j++) {
            result+=satisfactions.get(j)*index;
            index++;
        }
        return result;
    }

    public static int maxSatisfaction_(int[] satisfaction) {
        sort(satisfaction);
        ArrayList<Integer> results = new ArrayList<>();
        LinkedList<Integer> satisfactions = new LinkedList<>();
        for (int i = 0; i < satisfaction.length; i++) {
            satisfactions.add(satisfaction[i]);
        }
        zeroOneBag(satisfactions, 0, results, 1);

        int max = 0;
        for (int i = 0; i < results.size(); i++) {
            if(results.get(i)>max){
                max = results.get(i);
            }
        }
        return max;
    }

    public static void zeroOneBag(LinkedList<Integer> satisfactions, int value, ArrayList<Integer> results, int index){
        System.out.println(satisfactions);
        if(satisfactions.size()==0){
            results.add(value);
            return;
        }
        int node_value = satisfactions.get(0);
        satisfactions.remove(0);
        if(node_value>0){
            zeroOneBag(satisfactions, value + node_value*index, results, index+1);
            return;
        }
        LinkedList<Integer> satisfactions_copy = new LinkedList<>(satisfactions);
        zeroOneBag(satisfactions, value + node_value*index, results, index+1);
        zeroOneBag(satisfactions_copy, value, results, index); //不选
    }

    public static void main(String[] args) {
        System.out.println(maxSatisfaction_(new int[]{34,-27,-49,-6,65,70,72,-37,-57,92,-72,36,6,-91,18,61,77,-91,5,64,-16,5,20,-60,-94,-15,-23,-10,-61,27,89,38,46,57,33,94,-79,43,-67,-73,-39,72,-52,13,65,-82,26,69,67}));
    }
}
