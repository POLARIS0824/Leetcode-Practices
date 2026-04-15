public class gas_station_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int cur = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            cur += diff;

            if (cur < 0) {
                start = i + 1;
                cur = 0;
            }
        }

        if (total < 0) {
            return -1;
        } else {
            return start;
        }
    }

    public int mySolution(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
        }

        int sum = 0;
        int index = 0;
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            if (sum < 0) {
                index = i + 1;
                sum = 0;
            }
        }
        if (index == diff.length) {
            index = -1;
        }

        int tank = 0;
        for (int i = 0; i < diff.length; i++) {
            tank += diff[i];
        }
        if (tank < 0) {
            return -1;
        } else {
            return index;
        }
    }

    public static void main(String[] args) {
        gas_station_134 test = new gas_station_134();
//        System.out.println(test.canCompleteCircuit(
//                new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}
//        ));
//        System.out.println(test.mySolution(
//                new int[]{5, 8, 2, 8}, new int[]{6, 5, 6, 6}
//        ));
        System.out.println(test.mySolution(
                new int[]{3, 1, 1}, new int[]{1, 2, 2}
        ));
    }
}
