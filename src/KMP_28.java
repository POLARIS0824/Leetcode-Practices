public class KMP_28 {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);

//        // brute force
//        for (int i = 0; i < haystack.length() - needle.length(); i++) {
//            int j;
//            for (j = 0; j < needle.length(); j++) {
//                if (haystack.charAt(i + j) != needle.charAt(j)) {
//                    break;
//                }
//            }
//            if (j == needle.length()) {
//                return i;
//            }
//        }
//        return -1;
    }

    // KMP Algorithm with DFA Implementation
    public int strStr1(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int[][] dfa = new int[26][needle.length()];
        dfa[needle.charAt(0) - 'a'][0] = 1;

        int X = 0;
        for (int j = 1; j < needle.length(); j++) {
            for (int c = 0; c < 26; c++) {
                // no match
                dfa[c][j] = dfa[c][X];
            }

            // match
            int charIndex = needle.charAt(j) - 'a';
            dfa[charIndex][j] = j + 1;

            // update X
            X = dfa[charIndex][X];
        }

        // search
        int i, j;
        for (i = 0, j = 0; i < haystack.length() && j < needle.length(); i++) {
            int charIndex = haystack.charAt(i) - 'a';
            j = dfa[charIndex][j];
        }
        if (j == needle.length()) {
            return i - needle.length();
        }
        return -1;
    }

    // KMP Algorithm with Traditional Implementation
    public int strStr2(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        int i = 0, j = 0;
        int[] next = buildNext(needle);

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (j > 0) {  // mismatch
                j = next[j - 1];
            } else {
                i++;
            }
            // match successfully
            if (j  == needle.length()) {
                return i - needle.length();
            }
        }
        return -1;
    }

    private int[] buildNext(String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;
        int len = 0;  // 当前相同/共同前后缀的长度 (相当于 X)
        for (int i = 1; i < needle.length(); i++) {
            // mismatch
            while (len > 0 && needle.charAt(i) != needle.charAt(len)) {
                len = next[len - 1];
            }
            // match successfully
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
            }

            next[i] = len;
        }
        return next;
    }
}
