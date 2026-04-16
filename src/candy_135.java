public class candy_135 {
    public int candy(int[] ratings) {
        int res = 0;
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        // right > left
        for (int i = 1; i < ratings.length; i++) {
            candy[i] = 1;
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        // left > right
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1); // ⚠️ 注意贪心
            }
        }

        for (int num : candy) {
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        candy_135 test = new candy_135();
        System.out.println(test.candy(new int[]{1, 3, 2, 2, 1}));
    }
}
