import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
           char[] dir = new char[26];
           for(char c:strs[i].toCharArray()){
               dir[(c-'a')]++;
           }
            String dirStr = new String(dir);
            if(map.containsKey(dirStr)){
                List<String> groupStr = map.get(dirStr);
                groupStr.add(strs[i]);
                map.put(dirStr,groupStr);
            }else{
                List<String> groupStr = new ArrayList<>();
                groupStr.add(strs[i]);
                map.put(dirStr,groupStr);
            }
        }

        for (String key:map.keySet()) {
            List<String> groupStr = map.get(key);
            ans.add(groupStr);
        }
        return ans;
    }

    public static void main(String[] args) {
        new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
