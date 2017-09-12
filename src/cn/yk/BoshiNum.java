package cn.yk;

import java.util.Scanner;

/**
 * Created by tpusers on 2017/9/9.
 */
public class BoshiNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = 0;
        int mod4=0;
        int mod2=0;

        String[] ans = new String[n];
        for(int i=0;i<n;i++){
            l = in.nextInt();
            int[] array = new int[l];
            for(int j=0;j<l;j++){
                array[j] = in.nextInt();
                if(array[j]%4==0){
                    mod4++;
                }else if(array[j]%2==0){
                    mod2++;
                }
            }
            if(mod4+1>=l-mod4){
                ans[i] = "yes";
            }else
                if(mod4>=l-mod4-mod2) {
                    ans[i] = "yes";
                }else {
                    ans[i] = "no";
                }
            mod4 = 0;
            mod2 = 0;


        }
        for(int i=0;i<n;i++){
            System.out.println(ans[i]);
        }





    }
}
