import java.util.*;

public class next_greater_element_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                if (map.containsKey(nums2[stack.peek()])) {
                    int index = map.get(nums2[stack.peek()]);
                    ans[index] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }

        return ans;
    }
}
