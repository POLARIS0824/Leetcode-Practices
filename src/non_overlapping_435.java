import java.util.Arrays;
import java.util.Comparator;

public class non_overlapping_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        int nums = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[i - 1][1]) {
                nums++;
            } else {
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }

        return intervals.length - nums - 1;
    }

    public static void main(String[] args) {
        non_overlapping_435 test = new non_overlapping_435();
        int[][] intervals = {
                {-52, 31}, {-73, -26}, {82, 97}, {-65, -11},
                {-62, -49}, {95, 99}, {58, 95}, {-31, 49},
                {66, 98}, {-63, 2}, {30, 47}, {-40, -26}
        };
        System.out.println(test.mySolution(intervals));
    }

    // TODO: 按照结束时间排序
    public int mySolution(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int num = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                num++;
                end = intervals[i][1];
            }
        }

        return intervals.length - 1 - num;
    }
}
