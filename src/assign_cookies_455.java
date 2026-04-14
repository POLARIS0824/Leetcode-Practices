import java.util.Arrays;

public class assign_cookies_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // greedy
        Arrays.sort(s); // size
        int index = s.length - 1;
        int res = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                res++;
                index--;
            }
        }
        return res;
    }
}
