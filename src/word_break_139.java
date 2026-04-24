import java.util.List;

public class word_break_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i] 表示当前的字符串可否分割为单词序列
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // ⚠️ 求的是排列数，先遍历背包，后遍历物品
        for (int i = 0; i <= s.length(); i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (len <= i && dp[i - len] && word.equals(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
