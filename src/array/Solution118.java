package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangys
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        // 1. [1, ..., n], 第一行有1个元素，第n行有n个
        // 2. 第一行只有1
        // 3. 从2到n行，第一个元素和最后一个元素都是1
        // 4. 遍历序列中所有的元素
        // if(value[i][j]==0) :
        // value[i][j] = value[i - 1][j - 1] + value[i - 1][j]
        // value[i + 1][j+1] = value[i][j] + value[i][j + 1]
        List<List<Integer>> result = new ArrayList<>();
        if(numRows==0){
            return result;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                list.add(0);
            }
            result.add(list);
        }
//        System.out.println(result);
        result.get(0).set(0, 1);
        for (int i = 1; i < result.size(); i++) {
            result.get(i).set(0, 1);
            result.get(i).set(result.get(i).size() - 1, 1);
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                if(result.get(i).get(j)==0){
                    int value = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                    result.get(i).set(j, value);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //        输入: 5
        //        输出:
        //[
        //     [1],
        //    [1,1],
        //   [1,2,1],
        //  [1,3,3,1],
        // [1,4,6,4,1]
        //]
        Solution118 solu = new Solution118();
        List<List<Integer>> result = solu.generate(5);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
