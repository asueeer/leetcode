package stack;

import java.util.Stack;

/**
 * @author wangyisu
 */
class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!st1.empty()){
            st2.push(st1.pop());
        }
        int x = st2.pop();
        while(!st2.empty()){
            st1.push(st2.pop());
        }
        return x;
    }

    /** Get the front element. */
    public int peek() {
        while(!st1.empty()){
            st2.push(st1.pop());
        }
        int x = st2.peek();
        while(!st2.empty()){
            st1.push(st2.pop());
        }
        return x;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.empty()&&st2.empty();
    }
}
