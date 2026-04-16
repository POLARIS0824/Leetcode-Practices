import java.util.Arrays;
import java.util.Comparator;

public class burst_balloons_452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int res = 1;
        // [1, 6] [2, 8] [7, 12] [10, 16]
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                res++;
            } else { // 重叠
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }

        return res;
    }
}
