package tree;

import java.util.HashMap;

/**
 * @author wangyisu
 */
public class Trie {
    char c;
    HashMap<Character,Trie> nexts = new HashMap<>();

    public Trie(char c) {
        this.c = c;
    }

    public Trie() {
        c = '#';
    }


    public int add(String word) {
        Trie now = this;
        int size = 1;
        boolean haveSamePostfix = true;
        for (int i = word.length()-1; i > -1; i--) {
            char ch = word.charAt(i);
            if (!now.nexts.containsKey(ch)) {
                now.nexts.put(ch, new Trie(ch));
                haveSamePostfix = false;
            }
            now = now.nexts.get(ch);
            size++;
        }
        if(!haveSamePostfix){
            return size;
        }else{
            return 0;
        }
    }
}
