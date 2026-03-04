import edu.princeton.cs.algs4.In;

import java.util.HashMap;

public class four_sum_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            for (int num2 : nums2) {
                map.put(num + num2, map.getOrDefault(num + num2, 0) + 1);
            }
        }
        int count = 0;
        for (int num : nums3) {
            for (int num2 : nums4) {
                if (map.containsKey(-(num + num2))) {
                    count += map.get(-(num + num2));
                }
            }
        }
        return count;
    }
}
