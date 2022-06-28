import java.util.*;

class Solution {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // Comparator comp = pq.comparator();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < kArrays.get(i).size(); j++) {
                pq.offer(kArrays.get(i).get(j));
            }
        }
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        return ans;
    }
}

// Time Complexity: O(NlogN)

// Auxiliary Space : O(N)
