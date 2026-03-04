import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class remove_adjacent_duplicates_1047 {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        remove_adjacent_duplicates_1047 s = new remove_adjacent_duplicates_1047();
        System.out.println(s.removeDuplicates("abbaca"));
    }
}
