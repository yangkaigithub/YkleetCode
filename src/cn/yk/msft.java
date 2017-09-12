package cn.yk;


import java.util.Scanner;

/**
 * Created by tpusers on 2017/7/19.
 */
public class msft {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nn = in.nextInt();
        in.nextLine();
        boolean flag2 = false;
        for (int k = 0; k < nn; k++) {

            String a1 = in.nextLine();
            String a2 = in.nextLine();
            StringBuffer b1 = new StringBuffer();
            StringBuffer b2 = new StringBuffer();
            int m = 0;
            int n = 0;
            int dif = 0;
            int temp = 0;
            for (int i = 0; i < a1.length(); i++) {
                if (a1.charAt(i) != a2.charAt(i)) {
                    dif++;
                    b1 = b1.append(a1.charAt(i));
                    b2 = b2.append(a2.charAt(i));
                }
            }
            boolean flag = false;
            int p = 0;
            int cnt = 1000;
            while (b1.length()!=0) {
                for (int i = 0; i < b1.length(); i++) {
                    for (int j = i + 1; j < b1.length(); j++) {
                        if (b1.charAt(i) == b2.charAt(j) && b1.charAt(j) == b2.charAt(i)) {
                            m = i;
                            n = j;
                            flag = true;
                            dif = dif - 2;
                            break;
                        }

                    }
                    if (flag)
                        break;

                }
                if (flag) {
                    if (m > n) {
                        temp = m;
                        m = n;
                        n = temp;
                    }

                    b1.deleteCharAt(n);
                    b1.deleteCharAt(m);
                    b2.deleteCharAt(n);
                    b2.deleteCharAt(m);
                    flag = false;
                } else {
                    for (int i = 0; i < b1.length(); i++) {
                        if (b1.charAt(i) != 's' && b1.charAt(i) != 'f' && b1.charAt(i) != 'm' && b1.charAt(i) != 't') {
                            flag2 = true;
                            for (int j = 0; j < b1.length(); j++) {
                                if (b1.charAt(i) == b2.charAt(j)) {
                                    b1.setCharAt(i,b1.charAt(j));
                                    b1.deleteCharAt(j);
                                    b2.deleteCharAt(j);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    if(!flag2){
                        for (int i = 0; i < b1.length(); i++) {
                            for (int j = 1; j < b1.length(); j++) {
                                if (b1.charAt(i) == b2.charAt(j)) {
                                    b1.setCharAt(i,b1.charAt(j));
                                    b1.deleteCharAt(j);
                                    b2.deleteCharAt(j);
                                    break;
                                }
                            }
                            break;
                        }
                    }
                    flag2 = false;
                }

                p++;
            }

            System.out.println(p);
        }
    }
}
//fsmambfcs
//mfsmbfcsa

//shojnkm
//jsonkmh


