// ⚠️ 不要一直想着 HashSet

import java.util.HashSet;
import java.util.Set;

public class longest_consecutive_sequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int len = 1;

                while (set.contains(cur + 1)) {
                    cur++;
                    len++;
                }

                res = Math.max(res, len);
            }
        }

        return res;
    }
}
