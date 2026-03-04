// https://kamacoder.com/problempage.php?pid=1070

import java.util.Scanner;

public class developer_land {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        // prefixes
        int[] rowValue = new int[n];
        int[] colValue = new int[m];

        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                temp += arr[i][j];
            }
            rowValue[i] = temp;
        }

        temp = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp += arr[j][i];
            }
            colValue[i] = temp;
        }

        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            minVal = Math.min(minVal, Math.abs(rowValue[n - 1] - rowValue[i] - rowValue[i]));
        }
        for (int i = 0; i < m - 1; i++) {
            minVal = Math.min(minVal, Math.abs(colValue[m - 1] - colValue[i] - colValue[i]));
        }

        sc.close();
        System.out.println(minVal);
    }
}
