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
    public List<List<String>> partition_dp(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int len = s.length();

        // 判断 s[i..j]
        boolean[][] dp = new boolean[len][len];

        // dp[i][j] depends on dp[i+1][j-1]
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        Helper(s, 0, dp, temp, res);
        return res;
    }

    private void Helper(String s, int start, boolean[][] dp,
                        List<String> temp, List<List<String>> res) {
        // base case
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // backtracking
        for (int end = start; end < s.length(); end++) {
            if (!dp[start][end]) continue;

            temp.add(s.substring(start, end + 1));
            Helper(s, end + 1, dp, temp, res);
            temp.removeLast();
        }
    }
}
