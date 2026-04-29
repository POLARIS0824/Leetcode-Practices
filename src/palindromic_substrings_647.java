// ⚠️ 回文子串

public class palindromic_substrings_647 {
    public int countSubstrings(String s) {
        int length = s.length();

        // interval dp
        // 在 [i..j] 上，回文子串的数量
        boolean[][] dp = new boolean[length][length];
        // 初始化
        int res = 0;

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            res++;
        }

        // 按照区间长度遍历
        for (int len = 2; len <= length; len++) {
            for (int i = 0; i <= length - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }

        return res;
    }

    // double pointers 中心扩展法
    public int mySolution(String s) {
        int n = s.length();
        int res = 0;

        for (int i = 0; i < n; i++) {
            res += expand(s, i, i); // 奇数长度
            res += expand(s, i, i + 1); // 偶数长度
        }

        return res;
    }

    private int expand(String s, int left, int right) {
        int subCount = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            subCount++;
            left--;
            right++;
        }

        return subCount;
    }
}
