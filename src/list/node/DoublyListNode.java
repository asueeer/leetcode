package list.node;

/**
 * @author wangyisu
 */
public class DoublyListNode<E> {
    E val;
    DoublyListNode<E> pre;
    DoublyListNode<E> next;
    public DoublyListNode(E val) {
        this.val = val;
    }

    public static void main(String[] args) {
        DoublyListNode<Integer> doublyListNode = new DoublyListNode<>(0);
        System.out.println(doublyListNode.val);
    }
}


