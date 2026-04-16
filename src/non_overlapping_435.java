import java.util.Arrays;

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
                intervals[i][1] = intervals[i - 1][1];
            }
        }

        return intervals.length - nums - 1;
    }

    public static void main(String[] args) {
        non_overlapping_435 test = new non_overlapping_435();
        System.out.println(test.eraseOverlapIntervals(//TODO));
    }
}
