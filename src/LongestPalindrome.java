import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2016/11/20.
 */
public class LongestPalindrome {
    public static void main(String[] args){
        System.out.println(new LongestPalindrome().longestpalindrome("babad"));
    }
    String longestpalindrome(String s){
        Stack<Character> stack = new Stack<Character>();
        String str = "";
        String p_str = "";
        String pp_str = "";
        char[] c = new char[1000];
        try {
            for (int i = 0; i < s.length(); i++) {
                stack.push(s.charAt(i));
            }
            for (int i = 0; i < s.length(); i++) {
                str += stack.pop();
            }
            pp_str = str.substring(0, 1);
            for (int i = 1, j = 0; i <= s.length(); i++) {
                if (s.contains(pp_str)) {
                    p_str = p_str.length() >= pp_str.length() ? p_str : pp_str;
                } else pp_str = str.substring(++j, i);
                pp_str = str.substring(j, i + 1);
            }
        }catch(Exception e){}
        finally{
            return  p_str;
        }


    }
}
