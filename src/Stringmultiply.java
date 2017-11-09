public class Stringmultiply {
    public String multpity(String num1,String num2){
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }

        char zeroChar = '0';
        String ans="";
        StringBuffer n1 = new StringBuffer(num1);
        StringBuffer n2 = new StringBuffer(num2);
        n1 = n1.reverse();
        n2 = n2.reverse();
        int ans01 = 0;
        int l = 0;
        String[] midans = new String[num2.length()];
        for(int i=0;i<midans.length;i++){
            midans[i] = "";
            for (int j = 0; j < i  ; j++) {
                midans[i] += 0;
            }

        }
        for(int i=0;i<n2.length();i++){
            for(int j=0;j<n1.length();j++){
                ans01 = (n1.charAt(j)-zeroChar) * (n2.charAt(i)-zeroChar) + l;
                if(ans01>=10){
                    l = ans01/10;
                    ans01 = ans01 - l*10;
                }else{
                    l = 0;
                }
                midans[i]+=ans01;
                if((j == n1.length()-1)&&l!=0){
                    midans[i]+=l;
                    l=0;
                }
            }
        }
        int maxlength = 0;
        for(int i = 0;i<midans.length;i++){
            if(midans[i].length()>maxlength){
                maxlength = midans[i].length();
            }
        }
        for (int i = 0; i < midans.length; i++) {
            int l2 = midans[i].length();
            for (int j = 0; j < maxlength - l2; j++) {
                midans[i] += "0";
            }
        }
        l = 0;
        int ans02 = 0;
        for (int i = 0; i < maxlength; i++) {
            for (int j = 0; j < midans.length; j++) {
                ans02 += l + (midans[j].charAt(i)-zeroChar);
                l=0;
            }
            if(ans02>=10){
                l = ans02/10;
                ans02 = ans02 - 10*l;
                if(ans02>=10){
                    ans02 = ans02%10;
                }
            }else{
                l=0;
            }
            ans += ans02;
            ans02 = 0;
            if(i==maxlength-1){
                if(l>=10){
                    ans += l%10;
                    ans += l/10;
                }else
                    ans+=l;
            }

        }
        ans = new StringBuffer(ans).reverse().toString();
        ans = ans.replaceAll("^(0+)", "");

        return ans;
    }
    public static void main(String[] args) {
       new Stringmultiply().multpity("132","456");
    }
}
