package cn.yk;

/**
 * Created by tpusers on 2017/1/10.
 */
public class Request {
    private String reqstr;

    public String getReqstr() {
        return reqstr;
    }

    public void setReqstr(String reqstr) {
        this.reqstr = reqstr;
    }

    @Override
    public String toString(){
        return reqstr;
    }
}
