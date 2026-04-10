public class reverse_string2_541 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * k) {
            if (s.length() - i < k) {
                String sub = s.substring(i, s.length());
                String reverseSub = new StringBuilder(sub).reverse().toString();
                sb.replace(i, s.length(), reverseSub);
            } else if (s.length() - i < 2 * k && s.length() - i >= k) {
                String sub = s.substring(i, i + k);
                String remain = s.substring(i + k, s.length());
                String reverseSub = new StringBuilder(sub).reverse().toString();
                sb.replace(i, i + k, reverseSub);
                sb.append(remain);
            } else {
                String sub = s.substring(i, i + k);
                String remain = s.substring(i + k, i + 2 * k);
                String reverseSub = new StringBuilder(sub).reverse().toString();
                sb.replace(i, i + k, reverseSub);
                sb.append(remain);
            }
        }
        return sb.toString();
    }

    // simpler and more elegant
    public String reverseStr2(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, s.length() - 1);
            while (left < right) {
                char tmp = str[left];
                str[left] = str[right];
                str[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        String test = "abcd";
        reverse_string2_541 s = new reverse_string2_541();
        System.out.println(s.reverseStr(test, 2));
    }
}
