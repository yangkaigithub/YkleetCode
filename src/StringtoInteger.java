/**
 * Created by tpusers on 2016/12/21.
 */
public class StringtoInteger {
    public int myAtoi(String str) {
        String s = str.trim();
        int y = 0;
        int x = 0;
        Boolean b = true;
        int c = 0;
        for(int i=0;i<s.length();i++){
            x = s.charAt(i);
            if(x>='0'&&x<='9') {
                if (b) {
                    c = (Integer.MAX_VALUE - (x - '0')) / 10;
                    if (c >= y) {
                        y = y * 10 + (x - '0');
                    } else {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    c = (Integer.MIN_VALUE + (x - '0')) / 10;
                    if (-c >= y) {
                        y = y * 10 + (x - '0');
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }
            }
            else if(i==0) {
                if (x == '+')
                    continue;
                else if (x == '-') {
                    b = false;
                    continue;
                }
                return y;
            }
            else if(b == false)
                return -y;
            else return y;
        }
        if(b)
            return y;
        else
        return -y;
    }
    public static void main(String[] args){
        System.out.println(new StringtoInteger().myAtoi("b11228552307"));
    }
}
