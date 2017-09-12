package cn.yk;


/**
 * Created by tpusers on 2017/6/23.
 */
public class Test {
    public static void main(String[] args){
        String str = "<p>123456\n\t";
        char[] a  = new char[1];
        a[0] = 10;
        String s  = new String(a);
        str.replace("2","1");
        System.out.println(str);
    }
}
