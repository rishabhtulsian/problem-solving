import java.util.ArrayDeque;

class MyStack {
    private ArrayDeque<Integer> q1;
    private ArrayDeque<Integer> q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int e = q1.remove();
        swap();
        return e;
    }
    
    /** Get the top element. */
    public int top() {
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int e = q1.remove();
        q2.add(e);
        swap();
        return e;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    private void swap() {
        ArrayDeque<Integer> t = q1;
        q1 = q2;
        q2 = t;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */