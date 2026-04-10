import java.util.ArrayDeque;
import java.util.Deque;

public class sliding_window_maximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // 记录下标
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            // 1. 入 (维持单调递减)
            while (!deque.isEmpty() && nums[deque.peekLast()] <=  nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            // 2. 出
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 3. 记录答案
            if (i >= k - 1) {
                res[idx++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
