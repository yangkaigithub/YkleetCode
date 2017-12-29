import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flags = new boolean[s.length()];
        Set<String> wordSet = new HashSet<>();
        for(String word:wordDict){
            if(word.length()<=s.length()) {
                wordSet.add(word);
            }
        }
        String str = "";
        str += s.charAt(0);
        return wordBreak(s,0,0,str,wordSet);
    }
    public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] flags = new boolean[s.length()+1];
        Set<String> wordSet = new HashSet<>();
        for(String word:wordDict){
            if(word.length()<=s.length()) {
                wordSet.add(word);
            }
        }
        flags[0] = true;
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                if(flags[j]&&wordSet.contains(s.substring(j,i))){
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[s.length()];
    }
    boolean wordBreak(String s,int index,int tail,String str, Set<String> wordSet){
        if(tail == s.length()-1){
            if(wordSet.contains(str)) {
                return true;
            }else{
                return false;
            }
        }
        boolean flag = false;
        if(wordSet.contains(str)){
            flag = wordBreak(s,tail+1,tail+1, String.valueOf(s.charAt(tail+1)),wordSet);
        }
        if(flag){
            return true;
        }else {
            flag = wordBreak(s,index,tail+1,str + s.charAt(tail+1),wordSet);
        }
        return flag;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        String s = "leetcode";
        System.out.println(s.substring(0,3));
        new WordBreak().wordBreak2(s,wordDict);
    }
}
