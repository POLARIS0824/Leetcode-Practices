import java.util.*;

public class top_k_frequent_347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                Map.Entry.comparingByValue()
        ); // 初始化一个小顶堆，需要自定义 comparator

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        for (int i = 0; i < k; i++)
            ans[i] = pq.poll().getKey();

        return ans;
    }

    // Use Bucket Sort
    public int[] topKFrequent2(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Build Buckets With Lazy Loading
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // Reverse Output
        int count = 0;
        for (int i = buckets.length - 1; i >= 0 && count < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    ans[count++] = num;
                    if (count == k) break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        top_k_frequent_347 s = new top_k_frequent_347();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ans = s.topKFrequent2(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}
