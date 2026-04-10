import java.util.HashSet;

public class happy_number_202 {
//    public boolean isHappy(int n) {
//        int[] num = numToDigits(n);
//        int len = num.length;
//
//        HashSet<Integer> set = new HashSet<Integer>();
//        while (!set.contains(1)) {
//            int temp = 0;
//            for (int i = 0; i < len; i++) {
//                temp += num[i] * num[i];
//            }
//            if (set.contains(temp)) {
//                return false;
//            }
//            set.add(temp);
//            num = numToDigits(temp);
//            len = num.length;
//        }
//        return true;
//    }
//
//    public int[] numToDigits(int n) {
//        if (n == 0) return new int[]{0};
//        int temp = 0;
//        int len = (int) Math.log10(n) + 1;
//        int[] res = new int[len];
//
//        for (int i = len - 1; i >= 0; i--) {
//            res[i] = n % 10;
//            n = n / 10;
//        }
//        return res;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(new happy_number_202().isHappy(19));
//        System.out.println(new happy_number_202().isHappy(2));
//    }

    // 其实不需要单独转换一个数组，直接算 sum 就行
    private int sum(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = sum(n);
        }
        return n == 1;
    }
}
