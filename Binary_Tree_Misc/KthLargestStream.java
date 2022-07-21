import java.util.*;
class KthLargInStream {
    public static void main(String[] args) {
        
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    public void KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i : nums){
            pq.add(i);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while (pq.size() > k){
            pq.remove();
        }
        return pq.peek();
    }
}
// Time complexity: O(klogN)
// Space complexity: O(k)
