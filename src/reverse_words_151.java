import java.util.ArrayDeque;
import java.util.Deque;

public class reverse_words_151 {
    public String reverseWords(String s) {
        String res = "";
        Deque<String> stack = new ArrayDeque<>();
        s = s.trim().replaceAll("\\s+", " ");
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            stack.push(words[i]);
        }
        while (!stack.isEmpty()) {
            String word = stack.pop();
            res = res.concat(word);
            if (!word.equals(words[0])) {
                res += " ";
            }
        }
        return res;
    }

    // simpler and more elegant
    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");  // split directly
        for (int i = words.length - 1; i >= 0; i--) {   // don't need deque
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        reverse_words_151 s = new reverse_words_151();
        System.out.println(s.reverseWords("  hello world  "));
    }
}
