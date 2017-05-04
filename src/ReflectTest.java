import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by tpusers on 2016/12/29.
 */
public class ReflectTest {
    public static void main(String[] args){
        Person p = new Person();
        Field[] fl = p.getClass().getFields();
        System.out.println(p.str1 + " " + p.str2);
        for (Field f:fl){
            if(f.getType() == String.class){
                try {
                    String str = (String) f.get(p);
                    str = new String("dsfsfs");
                    f.set(p,str);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(p.str1 + " " + p.str2);

        try {
            String[] strs = new String[]{"dfs","dsfsfsf","dsfsfsfdawas"};
            Method m = Class.forName("Person").getMethod("printname", String[].class);
            m.invoke(p,(Object)strs);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
