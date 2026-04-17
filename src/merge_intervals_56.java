import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class merge_intervals_56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });

        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.getLast();
            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        merge_intervals_56 test = new merge_intervals_56();
        System.out.println(Arrays.deepToString(test.merge(new int[][]{
                {1, 3}
        })));
    }
}
