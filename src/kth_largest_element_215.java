import java.util.PriorityQueue;

public class kth_largest_element_215 {
    public int findKthLargest(int[] nums, int k) {
        // 小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }
}
