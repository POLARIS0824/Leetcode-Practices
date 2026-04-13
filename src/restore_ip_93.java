import java.util.ArrayList;
import java.util.List;

public class restore_ip_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        Helper(s, temp, 0, res, 0);
        return res;
    }

    private void Helper(String s, StringBuilder temp,
                        int start, List<String> res, int nums) {
        // base case
        if (nums > 4) {
            return;
        }

        if (nums == 4) {
            res.add(temp.toString());
            return;
        }

        // backtracking
        for (int end = start; end < s.length(); end++) {
            if (end - start + 1 > 3) {
                break;
            }

            if (!isValid(s.substring(start, end + 1))) {
                continue;
            }

            int prevLen = temp.length();
            if (nums < 3) {
                temp.append(s, start, end + 1).append(".");
                Helper(s, temp, end + 1, res, nums + 1);
            } else {
                if (end == s.length() - 1) {
                    temp.append(s, start, end + 1);
                    Helper(s, temp, end + 1, res, nums + 1);
                }
            }
            temp.setLength(prevLen);
        }
    }

    private boolean isValid(String s) {
        if (s.length() <= 0 || s.length() > 3) {
            return false;
        }
        int n = Integer.parseInt(s);
        if (n < 0 || n > 255) {
            return false;
        }
        return s.length() <= 1 || !s.startsWith("0");
    }

    public static void main(String[] args) {
        restore_ip_93 res = new restore_ip_93();
        res.restoreIpAddresses("25525511135");
    }
}
