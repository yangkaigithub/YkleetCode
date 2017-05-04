package cn.yk;

/**
 * Created by tpusers on 2017/1/10.
 */
public class HtmlFilter implements Filter{
    @Override
        public void doFilter(Request request, Responce responce) {
            String str = request.getReqstr();
            str = str.replace("<","[")
                    .replace(">","]");
            request.setReqstr(str);
    }
}
