import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class number_combination_17 {
    private static final String[] map = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        combineHelper(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void combineHelper(List<String> res, StringBuilder temp, String digits, int index) {
        // base case
        if (index == digits.length()) {
            res.add(temp.toString());
            return;
        }

        // backtracking
        int digit = digits.charAt(index) - '0';
        String letters = map[digit];
        for (int j = 0; j < letters.length(); j++) {
            temp.append(letters.charAt(j));
            combineHelper(res, temp, digits, index + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
