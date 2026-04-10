import java.util.Scanner;

public class matrix_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        if (n == 1) {
            res[0][0] = 1;
            return res;
        }

        int row = 0, col = n - 1;
        int temp = 1, total = n * n;

        while (temp <= total) {
            if (row == col) {
                res[row][col] = temp;
                break;
            }

            // top row
            for (int i = row; i < col; i++) {
                res[row][i] = temp;
                temp++;
            }

            // right col
            for (int i = row; i < col; i++) {
                res[i][col] = temp;
                temp++;
            }

            // bottom row
            for (int i = col; i > row; i--) {
                res[col][i] = temp;
                temp++;
            }

            // left col
            for (int i = col; i > row; i--) {
                res[i][row] = temp;
                temp++;
            }

            row++;
            col--;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        matrix_59 m = new matrix_59();
        int[][] res = m.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j] + "\t");
            }
        }
    }
}
