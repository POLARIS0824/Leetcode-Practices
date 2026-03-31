public class java_hw2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter a number between 0 and 1000: ");
//        int n = sc.nextInt();
//
//        int res = 0;
//        while (n > 0) {
//            int last = n % 10;
//            res += last;
//            n = n / 10;
//        }
//        System.out.println("The sum of the digits is " + res);
        StringBuffer s1 = new StringBuffer("Java");
        s1.delete(1, 3);
        System.out.println(s1);
    }
}
