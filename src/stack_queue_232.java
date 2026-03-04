import java.util.Stack;

public class stack_queue_232 {
    Stack<Integer> stIn;
    Stack<Integer> stOut;

    public stack_queue_232() {
        stIn = new Stack<>();
        stOut = new Stack<>();
    }

    public void push(int x) {
        stIn.push(x);
    }

    public int pop() {
        inToOut();

        return stOut.pop();
    }

    public int peek() {
        inToOut();

        return stOut.peek();
    }

    public void inToOut() {
        if (stOut.isEmpty()) {
            while (!stIn.isEmpty()) {
                stOut.push(stIn.pop());
            }
        }
    }

    public boolean empty() {
        return stIn.isEmpty() && stOut.isEmpty();
    }
}
