import addTwoNum.Class1;
import com.mathworks.toolbox.javabuilder.MWException;

import java.util.ArrayList;
import java.util.List;

public class testmatlab2java{
    public static void main(String[] args) throws MWException {
        Class1 class1 = new Class1();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        l1.add(1);
        l2.add(2);
        Object[] a = class1.addTwoNum(1,1,2);
        System.out.println(a[0]);

    }

}