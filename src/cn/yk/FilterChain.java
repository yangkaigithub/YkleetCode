package cn.yk;

import java.util.ArrayList;

/**
 * Created by tpusers on 2017/1/10.
 */
public class FilterChain implements Filter{

    public YkArrayList<Filter> getFilters() {
        return filters;
    }

    public void setFilters(YkArrayList<Filter> filters) {
        this.filters = filters;
    }

    private YkArrayList<Filter> filters;

    @Override
    public void doFilter(Request request, Responce responce) {
        for(Filter filter:filters){
            filter.doFilter(request,responce);
        }
    }
}
