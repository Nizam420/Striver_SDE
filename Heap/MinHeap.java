import java.util.*;

public class MinHeap {

    // minHeap function which take size of Queries and Queries as Input.
    // Returns an array out outputs depending on the query.
    static int[] minHeap(int n, int[][] q) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (q[i][0] == 0) {
                pq.add(q[i][1]);
            } else {
                if (!pq.isEmpty()) {
                    ans.add(pq.poll());
                }
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}

// Time Complexity: O(logN).

// Space Complexity: O(logN)