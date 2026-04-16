import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class height_reconstruction_406 {
    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][];

        // compare by height, then by k (reversed)
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        for (int[] person : people) {
            // ⚠️ 寻找 k + 1 个空位
            int space = person[1];
            for (int i = 0; i < people.length; i++) {
                if (res[i] == null) {
                    if (space == 0) {
                        res[i] = person;
                        break;
                    }
                    space--;
                }
            }
        }
        return res;
    }

    // TODO: optimization
    public int[][] mySolution(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            else return a[1] - b[1];
        });

        List<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(new int[people.length][]);
    }
}
