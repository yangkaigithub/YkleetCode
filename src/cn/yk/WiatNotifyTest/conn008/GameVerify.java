package cn.yk.WiatNotifyTest.conn008;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by tpusers on 2017/9/9.
 */
public class GameVerify {
    public static void main(String[] args) {
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        Scanner sc = new Scanner(System.in);
        StringBuffer str = new StringBuffer(sc.nextLine());
        StringBuffer str1 = new StringBuffer("");
        StringBuffer str2 = new StringBuffer("");
        StringBuffer str3 = new StringBuffer("");

        int level = 0;

        if(str.indexOf("+")!=-1){
            str1 = new StringBuffer(str.substring(0,str.indexOf("+")));
            str2 = new StringBuffer(str.substring(str.indexOf("+")+1,str.indexOf("=")));
            str3 = new StringBuffer(str.substring(str.indexOf("=")+1,str.length()));
        }else{
            str1 = new StringBuffer(str.substring(0,str.indexOf("-")));
            str2 = new StringBuffer(str.substring(str.indexOf("-")+1,str.indexOf("=")));
            str3 = new StringBuffer(str.substring(str.indexOf("=")+1,str.length()));
        }

        str1 = str1.reverse();
        str2 = str2.reverse();
        str3 = str3.reverse();

        if(str.indexOf("-")!=-1) {
            StringBuffer temp = str3;
            str3 = str1;
            str1 = temp;
        }
            for (int i = 0; i < str3.length(); i++) {
                Character c1 = '0';
                Character c2 = '0';
                if (str1.length() >= i + 1) {
                    c1 = str1.charAt(i);
                }
                if (str2.length() >= i + 1) {
                    c2 = str2.charAt(i);
                }

                Character c3 = str3.charAt(i);
                if (map.containsKey(c1)) {
                    c1 = (char) (map.get(c1) + '0');
                }
                if (map.containsKey(c2)) {
                    c2 = (char) (map.get(c2) + '0');
                }
                if (map.containsKey(c3)) {
                    c3 = (char) (map.get(c3) + '0');
                }
                if (c1 - '0' > 9 && c2 - '0' > 9 && c3 - '0' > 9) {
                    map.put(c1, 9);
                } else if (c1 == c2 && c1 - '0' > 9) {
                    map.put(c1, (c3 - '0') / 2);
                } else {
                    if (c1 - '0' > 9) {
                        if (c2 + level > c3) {
                            map.put(c1, c3 + 10 - level - c2);
//                        System.out.println(c1+ " " +(c3+10-level-c2));
                            level = 1;
                        } else {
                            map.put(c1, c3 - level - c2);
//                        System.out.println(c1+ " " +(c3-level-c2));
                            level = 0;
                        }
                    }
                    if (c2 - '0' > 9) {
                        if (c1 + level > c3) {
                            map.put(c2, c3 + 10 - level - c1);
//                        System.out.println(c2+ " " +(c3+10-level-c1));
                            level = 1;
                        } else {
                            map.put(c2, c3 - level - c1);
//                        System.out.println(c2+ " " +(c3-level-c1));
                            level = 0;
                        }
                    }

                    if (c3 - '0' > 9) {
                        if (c1 - '0' + c2 - '0' > 10) {
                            map.put(c3, c1 + c2 + level - 10 - '0' - '0');
//                        System.out.println(c3 + " " + (c1+c2+level-10-'0'-'0'));
                            level = 1;
                        } else {
                            map.put(c3, c1 + c2 + level - '0' - '0');
//                        System.out.println(c3 + " " + (c1+c2+level-'0'-'0'));
                            level = 0;
                        }
                    }
                }
            }
//        for(int i=0;i<map.size();i++){
//            if(map.containsKey((char)('A'+i))){
//                System.out.println((char)('A'+i) + " " + map.get((char)('A'+i)));
//            }
//
//
//        }

        int[] output = new int[26];
        Arrays.fill(output, -1);
        for(char ch: map.keySet()) {
            output[ch-'A'] = map.get(ch);
        }
        for(int i= 0; i < output.length; i++) {
            if(output[i] > -1) {
                System.out.println((char)('A' + i) + " " + output[i]);
            }
        }
//        System.out.println(map);
//        System.out.println(str);
    }
}
