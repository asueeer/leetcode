package bit;

import java.util.ArrayList;

public class Solution67 {
    public static String addBinary(String a, String b) {
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        for (int i = a.length() - 1; i > -1; i--) {
            listA.add(a.charAt(i) - '0');
        }
        for (int i = b.length() - 1; i > -1; i--) {
            listB.add(b.charAt(i) - '0');
        }
        // 保证list1的长度永远大于等于list1的长度
        if (listA.size() < listB.size()) {
            ArrayList<Integer> temp = listB;
            listB = listA;
            listA = temp;
        }
        int carry = 0;
        for (int i = 0; i < listB.size(); i++) {
            int sumI = (carry + listB.get(i) + listA.get(i));
            carry = (sumI >> 1) & 1;
            listA.set(i, sumI & 1);
        }
        for (int i = listB.size(); i < listA.size(); i++) {
            int sumI = listA.get(i) + carry;
            carry = (sumI >> 1) & 1;
            listA.set(i, sumI & 1);
        }
        if (carry != 0) {
            listA.add(carry);
        }

        // 001 [1, 0, 0]
        // 反向输出:
        StringBuilder ret = new StringBuilder();
        for (int i = listA.size() - 1; i > -1; i--) {
            ret.append(listA.get(i));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));  // "11", b = "1" ->100
    }
}
