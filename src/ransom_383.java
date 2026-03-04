import java.util.HashMap;

public class ransom_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] map = new int[26];
        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            map[c - 'a']--;
        }
        for (int num : map) {
            if (num <= 0) return false;
        }
        return true;
    }
}
