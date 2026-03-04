import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class three_sum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int x = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {  // 注意是和前一个去重
                continue;
            }
            if (x + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if (x + nums[len - 1]  + nums[len - 2] < 0) {
                continue;  // 注意此处优化，是 continue 不是 break
            }
            // double pointer
            int front = i + 1, rear = len - 1;
            while (front < rear) {
                int sum = nums[i] + nums[front] + nums[rear];
                if (sum < 0) {
                    front++;
                } else if (sum > 0) {
                    rear--;
                } else {
                    res.add(List.of(nums[front], nums[rear], x));
                    for (front++; front < rear && nums[front] == nums[front - 1]; front++);
                    for (rear--; front < rear && nums[rear] == nums[rear + 1]; rear--);
                }
            }
        }
        return res;
    }
}
