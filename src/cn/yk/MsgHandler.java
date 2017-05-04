package cn.yk;

/**
 * Created by tpusers on 2017/1/10.
 */
public class MsgHandler {
    public FilterChain getFc() {
        return fc;
    }

    public void setFc(FilterChain fc) {
        this.fc = fc;
    }

    private FilterChain fc;
    public void doHander(Request request,Responce responce){
        fc.doFilter(request,responce);
    }
}
