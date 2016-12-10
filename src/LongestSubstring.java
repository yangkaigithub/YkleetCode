import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/11/19.
 */
public class LongestSubstring {
    public static void main(String[] args){
        System.out.println(new LongestSubstring().longestsubstring("dwsdadweeqw"));
    }
    int longestsubstring(String str){
        int ans = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i=0,j=0;i<str.length();i++){

            if(map.containsKey(str.charAt(i))){
                j = j>(map.get(str.charAt(i))+1)? j:(map.get(str.charAt(i))+1);
           }
            map.put(str.charAt(i),i);
           ans = ans>(i-j+1)? ans:(i-j+1);
        }
        return ans;
    }
}
