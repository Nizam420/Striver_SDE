import java.util.*;

// Brute Force Approach to find largest rectangle area in Histogram
class Main {
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty())
                leftSmall[i] = 0;
            else
                leftSmall[i] = st.peek() + 1;
            st.push(i);
        }

        // clear the stack to be re-used
        while (!st.isEmpty())
            st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty())
                rightSmall[i] = n - 1;
            else
                rightSmall[i] = st.peek() - 1;

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;

    }

    public static void main(String args[]) {
        int arr[] = { 2, 1, 5, 6, 2, 3, 1 };
        // int n = 7;
        System.out.println("The largest area in the histogram is " +
                largestRectangleArea(arr));

    }
}

// Time Complexity: O( N )

// Space Complexity: O(3N) where 3 is for the stack, left small array and a
// right small array