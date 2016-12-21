import java.util.Stack;

/**
 *
 * dfsdffsdfsfsdsdfsdfsdfadfasdf
 * Created by Administrator on 2016/12/10.
 */
public class ReverseInteger {
    public static void main(String[] args){

        System.out.println(new ReverseInteger().reverse(153478269));

    }

    public int reverse(int x) {
        long y = 0;
        while(x != 0){
            y = y*10 + x%10;
            x = x/10;
            if(y>Integer.MAX_VALUE||y<Integer.MIN_VALUE)
                return 0;
        }

        return (int)y;
    }

}

