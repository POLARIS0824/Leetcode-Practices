import java.util.ArrayList;
import java.util.List;

public class partition_labels_763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            last[c - 'a'] = i;
        }

        int end = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            len++;
            if (i == end) {
                res.add(len);
                len = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        partition_labels_763 test = new partition_labels_763();
        // "ababcbacadefegdehijhklij"
        // "ababcbaca defegde hijhklij"
        System.out.println(test.partitionLabels("caedbdedda"));
    }
}
