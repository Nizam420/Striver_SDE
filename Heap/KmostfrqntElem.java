import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[k];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (map.get(a) - map.get(b)));
        for (int n : map.keySet()) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int i = 0;
        int[] ans = new int[k];
        while (!pq.isEmpty()) {
            int rem = pq.poll();
            ans[i++] = rem;
        }
        return ans;
    }
}

// Time Complexity: O(klogN)

// Auxiliary Space : O(N)