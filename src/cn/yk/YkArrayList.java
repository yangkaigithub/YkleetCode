package cn.yk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tpusers on 2017/1/10.
 */
public class YkArrayList<E> extends ArrayList<E> {

    public YkArrayList<E> addreturnList(E item){
        add(item);
        YkArrayList<E> es = (YkArrayList<E>) this.clone();
        return es;
    }
}
