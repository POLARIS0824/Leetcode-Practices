import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class four_sum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < len - 3; i++) {
            // pruning
            if (nums[i] > target && nums[i] >= 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {
                // pruning
                if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int front = j + 1, rear = len - 1;
                while (front < rear) {
                    int sum = nums[i] + nums[j] + nums[front] + nums[rear];
                    if (sum > target) {
                        rear--;
                    } else if (sum < target) {
                        front++;
                    } else {
                        res.add(List.of(nums[i], nums[j], nums[front], nums[rear]));
                        for (front++; front < rear && nums[front] == nums[front - 1]; front++);
                        for (rear--; front < rear && nums[rear] == nums[rear + 1]; rear--);
                    }
                }
            }
        }
        return res;
    }
}
