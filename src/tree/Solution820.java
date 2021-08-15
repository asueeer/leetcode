package tree;


import java.util.HashSet;
import java.util.Iterator;

/**
 * @author wangyisu
 */
public class Solution820 {
    public static int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        int size = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(words[i].length()>words[j].length()){
                    swap(words,i,j);
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            size+=trie.add(words[i]);
        }
        return size;
    }

    private static void swap(String[] words, int i, int j) {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(minimumLengthEncoding(new String[]{"time", "me"}));
        System.out.println(minimumLengthEncoding(new String[]{"me", "time"}));
    }
}
