import com.mathworks.toolbox.javabuilder.MWException;
import ykmatlab2java.Ykjava2matlab;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by tpusers on 2016/12/21.
 */
public class testmatlab2java {
    public static void main(String[] args) throws MWException {
        Ykjava2matlab ykjava2matlab = new Ykjava2matlab();

        int[] x = {1};
        int[] y = {2};
        Object[] z = new Ykjava2matlab().ykmatlab2java(2,x,y);
        System.out.println(z[1]);
    }
}
