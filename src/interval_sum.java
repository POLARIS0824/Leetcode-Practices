// https://kamacoder.com/problempage.php?pid=1070

import java.util.Scanner;

public class interval_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prefixes = new int[n + 1];

        int prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += sc.nextInt();
            prefixes[i + 1] = prefix;
        }

        while (sc.hasNextInt()) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(prefixes[end + 1] - prefixes[start]);
        }

        sc.close();
    }
}
