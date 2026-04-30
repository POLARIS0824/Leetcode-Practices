// ⚠️ 核心逻辑：以我为高度，最高可以扩展多远
// 目标：寻找左右两侧第一个比自己矮的元素 -> 单调栈

import java.util.ArrayDeque;
import java.util.Deque;

public class largest_rectangle_84 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        // ⚠️ 注意这个
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < newHeights.length; i++) {
            // 找到了右边界
            while (newHeights[i] < newHeights[stack.peek()]) {
                int mid = stack.pop();
                int w = i - stack.peek() - 1;
                int h = newHeights[mid];
                res = Math.max(res, w * h);
            }
            stack.push(i);
        }

        return res;
    }
}
