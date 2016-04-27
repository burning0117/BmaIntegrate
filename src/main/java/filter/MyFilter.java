package filter;

import domain.AdminUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lily on 2016/4/27.
 */
public class MyFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1= (HttpServletRequest) request;
        HttpServletResponse response1= (HttpServletResponse) response;
        AdminUser adminUser= (AdminUser) request1.getSession().getAttribute("existAdminUser");
        if (adminUser!=null){
             chain.doFilter(request,response);
        }else {
            ((HttpServletResponse) response).sendRedirect("http://localhost:8080/adminUserAction_login.action");
        }
    }

    public void destroy() {

    }
}
