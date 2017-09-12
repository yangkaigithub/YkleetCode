import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tpusers on 2017/8/7.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> a =  triangle.get(triangle.size()-1);
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                a.set(j,Math.min(a.get(j),a.get(j+1)) + triangle.get(i).get(j)) ;
            }
        }
        return a.get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();
        List<Integer> list4 = new ArrayList<Integer>();
        list1.add(2);
        list2.add(3);list2.add(4);
        list3.add(6);list3.add(5);list3.add(7);
        list4.add(4);list4.add(1);list4.add(8);list4.add(3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        System.out.println(new Triangle().minimumTotal(lists));
    }

}
