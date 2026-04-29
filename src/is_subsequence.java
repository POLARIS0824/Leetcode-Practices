public class is_subsequence {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[s.length()][t.length()] == s.length();
    }

    // double pointers
    public boolean mySolution(String s, String t) {
        if (s == null || s.isEmpty()) return true;
        int sIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(sIndex) == t.charAt(i)) {
                sIndex++;
            }
            if (sIndex == s.length()) break;
        }

        return sIndex == s.length();
    }

    public static void main(String[] args) {
        is_subsequence test = new is_subsequence();
        System.out.println(test.mySolution("abc", "ahbgdc"));
    }
}
