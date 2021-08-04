package travel;

import javax.servlet.*;
import java.io.IOException;

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