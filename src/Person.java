/**
 * Created by tpusers on 2016/12/28.
 */
 class People {
        protected People(){
            System.out.println("people's constractor");
        }
}
    public class Person extends People{
     public String str1 = "12234";
     public String str2 = "jklb";
     public Person(){
         System.out.println("person's constractor");
    }
    public void printname(String[] str){
        System.out.println(str);
    }
}