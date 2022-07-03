
import java.util.*;

class MinStack {
    Stack<Long> st = new Stack<>();
    Long mini;

    public MinStack() {
        mini = Long.MAX_VALUE;
    }

    public void push(int val) {
        Long value = Long.valueOf(val);
        if (st.isEmpty()) {
            mini = value;
            st.push(value);
        } else {
            if (value < mini) {
                st.push(2 * value - mini);
                mini = value;
            } else {
                st.push(value);
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        Long value = st.pop();
        if (value < mini) {
            mini = 2 * mini - value;
        }
    }

    public int top() {
        Long value = st.peek();
        if (value < mini) {
            return mini.intValue();
        }
        return value.intValue();
    }

    public int getMin() {
        return mini.intValue();
    }
}

// Time Complexity: O(1)

// Space Complexity: O(N)