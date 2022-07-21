import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums){
            pq.offer(i);
        }
        while (pq.size() > k){
            pq.remove();
        }
        return pq.peek();
    }
}

// Time complexity: O(N)
// Space complexity: O()