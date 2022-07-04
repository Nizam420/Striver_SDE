import java.util.ArrayList;
import java.util.Stack;

public class Stock_span {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < price.size(); i++) {
            while (!st.isEmpty() && price.get(i) >= price.get(st.peek())) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans.add(i + 1);
            } else {
                ans.add(i - st.peek());
            }
            st.push(i);
        }
        return ans;
    }
}