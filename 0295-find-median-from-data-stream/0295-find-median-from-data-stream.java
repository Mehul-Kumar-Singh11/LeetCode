import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {
    // Max-heap for the smaller half
    private PriorityQueue<Integer> small_half;
    // Min-heap for the larger half
    private PriorityQueue<Integer> large_half;

    public MedianFinder() {
        small_half = new PriorityQueue<>(Collections.reverseOrder());
        large_half = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 1. Add to small_half
        small_half.offer(num);

        // 2. Balance Values
        large_half.offer(small_half.poll());

        // 3. Balance Sizes
        if (large_half.size() > small_half.size()) {
            small_half.offer(large_half.poll());
        }
    }

    public double findMedian() {
        if (small_half.size() > large_half.size()) {
            return small_half.peek();
        } else {
            return (small_half.peek() + large_half.peek()) / 2.0;
        }
    }
}