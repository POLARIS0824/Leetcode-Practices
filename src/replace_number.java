import java.util.Scanner;

public class replace_number {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder(str.length() * 6);
        String num = "number";
        for (Character c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(num);
            } else {
                sb.append(c);
            }
        }
        sc.close();
        System.out.println(sb);

        // 一行搞定，代码极简
        System.out.println(str.replaceAll("\\d", "number"));
    }
}
