package travel;

import javax.servlet.*;
import java.io.IOException;
/**
 * JSP에서 넘어온 데이터를 UTF-8로 인코딩하는 클래스
 * @author 김정은
 *
 */
public class EncodingFilter implements Filter {

    String encoding;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding");
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        request.setCharacterEncoding(encoding);
//        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);

    }


    @Override
    public void destroy() {

    }

}