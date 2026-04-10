public class repeated_substr_459 {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                String sub = s.substring(0, i);
                int j;
                for (j = i; j < s.length(); j += sub.length()) {
                    if (!s.startsWith(sub, j)) {  // 指定偏移量
                        break;
                    }
                }
                if (j == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        repeated_substr_459 s = new repeated_substr_459();
        System.out.println(s.repeatedSubstringPattern("aba"));
    }
}
