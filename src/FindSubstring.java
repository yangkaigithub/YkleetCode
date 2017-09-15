import cn.yk.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tpusers on 2017/9/15.
 */
public class FindSubstring {
    class Posandmap{
        public int pos;
        public Map<String,Integer> wordsmapVer;
        public Posandmap(int pos,Map<String,Integer> wordsmapVer){
            this.pos = pos;
            this.wordsmapVer = wordsmapVer;

        }

    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(words.length*words[0].length()>s.length()){
            return null;
        }
        int wordslength = words.length*words[0].length();
        int wordlength = words[0].length();
        int[] dp = new int[s.length()];
        Map<String,Integer> wordsmap = new HashMap<>();
        Map<String,Posandmap> posmap = new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(wordsmap.containsKey(words[i])){
                wordsmap.put(words[i],wordsmap.get(words[i])+1);
            }else{
                wordsmap.put(words[i],1);
            }
        }
        Map<String,Integer> wordsmapVer = wordsmap;
        for(int j = 0;j<wordlength;j++) {
            for (int i = j; i <= j+s.length() - wordslength; i = i + wordlength) {
                String str = s.substring(i, i + wordlength);
                if (wordsmapVer.containsKey(str)){
                    if(wordsmapVer.get(str)==0){
                        dp[i]= dp[i-wordlength]-posmap.get(str).pos+1;
                        wordsmapVer = posmap.get(str).wordsmapVer;
                        continue;
                    }
                    else {
                            wordsmapVer.put(str, wordsmapVer.get(str) - 1);
                            if (wordsmapVer.get(str) == 0) {
                                posmap.put(str, new Posandmap(i,wordsmapVer));
                            }
                            if (i >= wordlength) {
                                dp[i] = dp[i - wordlength] + 1;
                            }else {
                                dp[i] = 1;
                            }
                    }
                    }
                if (dp[i] == words.length) {
                    list.add(i - (words.length - 1) * wordlength);
                    dp[i] = dp[i] - 1;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"foo","bar"};
        new FindSubstring().findSubstring("barfoothefoobarman",words);
    }
}
