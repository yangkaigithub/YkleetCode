import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Administrator on 2016/11/20.
 */
public class LongestPalindrome {
    public static void main(String[] args){
        System.out.println(new LongestPalindrome().longestpalindrome("bbddddfghjhgf"));
    }
    String longestpalindrome(String s){
        int maxlength=1;
        String maxstr = s.substring(0,1);
        int length = 0;
        int lo =0;
        int high =0;
        for(int i=0;i<s.length();i++){
            lo = i;
           high=i+1;
           while(lo>=0&&high<s.length()) {
               if (s.charAt(lo) == s.charAt(high)) {
                   length= length+2;
               }else{
                   break;
               }
               lo--;
               high++;
           }
           if(length>maxlength){
               maxlength=length;
               maxstr = s.substring(lo+1,high);
           }
           length = 0;
       }


       length = 1;
       for(int i=1;i<s.length()-1;i++){
           lo=i-1;
           high=i+1;
           while(lo>=0&&high<s.length()) {
               if (s.charAt(lo) == s.charAt(high)) {
                   length = length + 2;
               } else {
                   break;
               }
               lo--;
               high++;
           }
               if(length>maxlength){
                   maxlength = length;
                   maxstr = s.substring(lo+1,high);
               }
               length = 1;
           }
       return maxstr;
    }
}
