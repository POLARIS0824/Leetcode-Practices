import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class java_hw3_2 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        Random random = new Random();

        while (set.size() < 5) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                char c = (char) (random.nextInt(26) + 'A');
                sb.append(c);
            }
            for (int i = 0; i < 4; i++) {
                int digit = random.nextInt(10);
                sb.append(digit);
            }

            set.add(sb.toString());
        }

        for (String s : set) {
            System.out.println(s);
        }
    }
}
