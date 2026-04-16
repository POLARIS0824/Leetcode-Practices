public class lemonade_change_860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) {
            return false;
        }

        // 5, 10, 20
        int[] money = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                money[0]++;
            } else if (bills[i] == 10) {
                money[1]++;
                if (money[0] > 0) {
                    money[0]--;
                } else {
                    return false;
                }
            } else {
                money[2]++;
                if (money[0] < 1 && money[1] < 1) {
                    return false;
                }
                if (money[1] > 0) {
                    money[1]--;
                    money[0]--;
                    if (money[0] < 0) {
                        return false;
                    }
                } else {
                    money[0] -= 3;
                    if (money[0] < 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        lemonade_change_860 test = new lemonade_change_860();
        System.out.println(test.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
