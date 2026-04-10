import java.util.Scanner;

public class java_hw3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] counts = new int[24];

        String str = sc.nextLine();
        str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                counts[c - 'a']++;
            }
        }

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.print((char) (i + 'a') + ": " + counts[i] + "  ");
            }
        }
    }
}
