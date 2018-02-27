import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Character,Character[]> map = new HashMap<>();
        map.put('2',new Character[]{'a','b','c'});
        map.put('3',new Character[]{'d','e','f'});
        map.put('4',new Character[]{'g','h','i'});
        map.put('5',new Character[]{'j','k','l'});
        map.put('6',new Character[]{'m','n','o'});
        map.put('7',new Character[]{'p','q','r','s'});
        map.put('8',new Character[]{'t','u','v'});
        map.put('9',new Character[]{'w','x','y','z'});
        char c[] = new char[digits.length()];
        List<String> ans = new ArrayList<>();
        int l = digits.length();
        if(l==0){
            return ans;
        }
        help(c,map,l,digits,ans);
        return ans;
    }
    public void help(char[]c,Map<Character,Character[]> map,int l,String digits,List<String> ans){
        if(l==0){
            String s = new String(c);
            ans.add(s);
            return;
        }
        for (char digit:map.get(digits.charAt(l-1))) {
            c[l-1] = digit;
            help(c,map,l-1,digits,ans);
        }

    }

    public static void main(String[] args) {
        new LetterCombinationsofaPhoneNumber().letterCombinations("23");
    }
}
