import java.util.ArrayList;
import java.util.List;

public class palindrome_partitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        partitionHelper(res, temp, s, new StringBuilder(), 0);
        return res;
    }

    private void partitionHelper(List<List<String>> res, List<String> temp,
                                 String s, StringBuilder str, int index) {
        // base case
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // backtracking
        for (int i = index; i < s.length(); i++) {
            str.append(s.charAt(i));
            String ss = str.toString();
            if (isPalindrome(ss)) {
                temp.add(ss);
                partitionHelper(res, temp, s, new StringBuilder(), i + 1);
                temp.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int headIndex, rearIndex;
        for (headIndex = 0, rearIndex = s.length() - 1; headIndex < rearIndex; headIndex++, rearIndex--) {
            if (s.charAt(headIndex) != s.charAt(rearIndex)) {
                return false;
            }
        }
        return true;
    }

    // TODO: Use DP to solve

}
