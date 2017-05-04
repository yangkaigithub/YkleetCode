package cn.yk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tpusers on 2017/1/10.
 */
public class RespDM {
    public static void main(String[] args){
        String str = "<td>,你需要伟哥么<td>";
        YkArrayList<Filter> filters = new YkArrayList<Filter>();
        filters = filters.addreturnList(new HtmlFilter())
                .addreturnList(new SenistiveFilter());

        String str2 = str.replace("<","[")
                .replace(">","]");


        FilterChain fc = new FilterChain();
        fc.setFilters(filters);
        MsgHandler msgHandler = new MsgHandler();
        msgHandler.setFc(fc);
        Request request = new Request();
        request.setReqstr(str);
        Responce responce = new Responce();
        responce.setRespstr("  ");
        msgHandler.doHander(request,responce);

        System.out.println(request);
    }

}
