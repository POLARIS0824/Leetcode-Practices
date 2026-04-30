// ⚠️ 注意下标不是实际数值

import java.util.ArrayDeque;
import java.util.Deque;

public class trapping_rain_water_42 {
    public int trap(int[] height) {
        int len = height.length;
        int res = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int midIndex = stack.pop();
                if (!stack.isEmpty()) {
                    int leftIndex = stack.peek();
                    int h = Math.min(height[leftIndex], height[i]) - height[midIndex];
                    int w = i - leftIndex - 1;
                    res += h * w;
                }
            }
            stack.push(i);
        }

        return res;
    }

    // O(n) mem solution
    public int trap2(int[] height) {
        int len = height.length;

        int[] left = new int[len];
        left[0] = height[0];

        int[] right = new int[len];
        right[len - 1] = height[len - 1];

        int res = 0;

        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        for (int i = 0; i < len; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }

        return res;
    }

    // two pointers -> O(1) mem
    public int mySolution(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int lMax = 0, rMax = 0;

        while (left <= right) {
            lMax = Math.max(height[left], lMax);
            rMax = Math.max(height[right], rMax);

            if (lMax < rMax) {
                res += lMax - height[left];
                left++;
            } else {
                res += rMax - height[right];
                right--;
            }
        }

        return res;
    }
}
