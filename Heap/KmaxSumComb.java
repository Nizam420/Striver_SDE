import java.util.*;

public class KmaxSumComb {
    public static ArrayList<Integer> kMaxSumCombination(ArrayList<Integer> a, ArrayList<Integer> b, int n, int k) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = a.get(i) + b.get(j);
                pq.add(sum);
            }
        }
        while (k > 0) {
            ans.add(pq.peek());
            pq.poll();
            k--;
        }
        return ans;
    }
}

// Time Complexity: O(N2)

// Auxiliary Space : O(N)