package bitc.fullstack503.e2teamproject.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheck implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("userId") == null) {
            response.sendRedirect("/user/?errMsg=로그인이 필요합니다.");
            return false;
        }


        String requestURI = request.getRequestURI();
        if (requestURI.startsWith("/board/manager")) {
            Object userLevel = session.getAttribute("userLevel");

            if (userLevel == null || !userLevel.toString().equals("1")) {
                response.sendRedirect("/user/?errMsg=관리자 권한이 필요합니다.");
                return false;
            }
        }
        
        return true;
    }
}
