import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class reverse_polish_150 {
    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        Deque<Integer> digits = new ArrayDeque<>();

        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                int top = digits.pop();
                int bottom = digits.pop();
                int res = switch (token) {
                    case "+" -> res = bottom + top;
                    case "-" -> res = bottom - top;
                    case "*" -> res = bottom * top;
                    case "/" -> res = bottom / top;
                    default -> throw new IllegalArgumentException("invalid input");
                };
                digits.push(res);
            } else {
                digits.push(Integer.parseInt(token));
            }
        }
        return digits.pop();
    }
}
