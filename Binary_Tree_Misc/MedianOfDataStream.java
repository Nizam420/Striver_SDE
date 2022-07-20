import java.util.*;

class MedianDataStream {
    private PriorityQueue<Integer> maxHeap = null;
    private PriorityQueue<Integer> minHeap = null;

    public void MedianFinder() {
        maxHeap = new PriorityQueue<Integer>((a, b) -> (b - a));
        minHeap = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0 || maxHeap.peek() >= num){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }
        balance();
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }
        else if (minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }
        else{
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public void balance(){
        if (maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }
        else if (minHeap.size() - maxHeap.size() > 1){
            maxHeap.offer(minHeap.poll());
        }
    }
    public static void main(String[] args) {
        
    }
}

// Time complexity: O(klogN)
// Space complexity: O(k)