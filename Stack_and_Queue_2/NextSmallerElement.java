import java.util.*;

public class NextSmallerElement {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for (int i = n - 1; i >= 0; i--) {
            while (st.peek() >= arr.get(i)) {
                st.pop();
            }
            ans.add(st.peek());
            st.push(arr.get(i));
        }
        Collections.reverse(ans);
        return ans;
    }
}

// Time Complexity: O(N)

// Space Complexity: O(N)