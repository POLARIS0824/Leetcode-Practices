// ⚠️ 前缀和➕哈希表

import java.util.HashMap;
import java.util.Map;

public class subarray_sum_k_560 {
    public int subarraySum(int[] nums, int k) {
        // prefix[r] - prefix[l-1] = sumOf[l..r]
        // prefix[r] - prefix[l-1] = k
        // prefix[l-1] = prefix[r] - k

        int res = 0;
        int sum = 0;
        // 用 map 存当前前缀和出现了多少次
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            // 出现次数 + 1
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
