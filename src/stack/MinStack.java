package stack;

import java.util.Stack;

class MinStack {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MinStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
        st2.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        st1.push(x);
        if(x<=st2.peek()){
            st2.push(x);
        }
    }

    public void pop() {
        int x = st1.pop();
        if(x==st2.peek()){
            st2.pop();
        }
    }

    public int top() {
        return st1.peek();
    }

    public int getMin() {
        return st2.peek();
    }
}