import java.util.*;

/**
 * Created by Administrator on 2016/11/20.
 */
public class ZigZag {
    public static void main(String[] args){
        System.out.println(new ZigZag().convert("ABCD",2));
    }
    private  String convert(String s, int numRows) {

        String str = "";
        int t = (2*numRows-2)>0?(2*numRows-2):1;
        String[] ss = new String[numRows];
        for (int i=0;i<s.length();i++){
            if(i<numRows){
                ss[i] = "";
            }
            if(i%t<numRows){
                ss[i%t] += s.charAt(i);
            }
            else{
                ss[t-i%t] += s.charAt(i);
            }
        }
        for(int i=0; i<numRows; i++){
            str += ss[i];
        }
        return str;
    }
}
