import java.util.*;

public class group_anagrams_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String key = new String(str);
//            if (map.containsKey(key)) {
//                map.get(key).add(strs[i]);
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(strs[i]);
//                map.put(key, list);
//            }
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
