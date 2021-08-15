package string;

import list.node.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class Solution50 {
    public char firstUniqChar(String s) {
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return 'a';
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> arrayA = new ArrayList<>();
        while (headA != null) {
            arrayA.add(headA);
            headA = headA.next;
        }
        HashSet<ListNode> hashB = new HashSet<>();
        while (headB != null) {
            hashB.add(headB);
            headB = headB.next;
        }
        for (int i = 0; i < arrayA.size(); i++) {
            if (hashB.contains(arrayA.get(i))) {
                return arrayA.get(i);
            }
        }
        return null;
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }


    public static int removeElement(int[] nums, int val) {
        int head = 0, tail = nums.length - 1; // tail始终指向最后一个不等于val的元素
        while (head < tail) {
            if (nums[tail] == val) {
                tail--;
                continue;
            }
            if (nums[head] == val) {
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
            }
            head++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return nums.length;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
//        sort(nums);
//        System.out.println(Arrays.toString(nums));
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }
}
