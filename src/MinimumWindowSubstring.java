import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        Map<Character,Integer> dictMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if(dictMap.containsKey(t.charAt(i))){
                dictMap.put(t.charAt(i),dictMap.get(t.charAt(i))+1);
            }else{
                dictMap.put(t.charAt(i),1);
            }

        }
        int l = s.length();
        String str = s+" ";
        Map<Character,Integer> map = new LinkedHashMap<>();
        Map<Character,Integer> midmap = new HashMap<>(dictMap);
        for (int i = 0; i < s.length(); i++) {

            String midstr;
            char c = s.charAt(i);
            if(dictMap.containsKey(c)){
                if(map.containsKey(c)&&midmap.get(c)==0){
                    map.remove(c);
                    map.put(c,i);
                }else{
                    if(midmap.get(c)==dictMap.get(c)){
                        map.put(c,i);
                    }
                    midmap.put(c,midmap.get(c)-1);
                    boolean flag=true;
                    for (int j: midmap.values()) {
                        if(j!=0) {
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        midstr = s.substring((Integer) map.values().toArray()[0],i+1);
                        str = str.length()>midstr.length()?midstr:str;
                        midmap.put((Character) map.keySet().toArray()[0],midmap.get(map.keySet().toArray()[0])+1);
                        map.remove(map.keySet().toArray()[0]);

                    }
                }
            }

        }
        if(str.equals(s+" ")){
            return "";
        }
        return str;
    }

    public static void main(String[] args) {
        new MinimumWindowSubstring().minWindow("aaflslflsldkalskaaa","aaa");

    }
}
