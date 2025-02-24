package bitc.fullstack503.e2teamproject.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

public class LoginCheck implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        Object userId = session.getAttribute("userId");
        Object userLevel = session.getAttribute("userLevel");
        String requestURI = request.getRequestURI();

        // 1. 로그인 체크
        if (requestURI.startsWith("/pro") ) {
            if (userId == null) {
                sendAlert(response, "로그인이 필요합니다.", "/user/");
                return false;
            }
        }

        // 2. 관리자 권한 체크
        if (requestURI.startsWith("/user/manager") || requestURI.startsWith("/user/member")
                || requestURI.startsWith("/notice/write") || requestURI.startsWith("/event/write") || requestURI.startsWith("/crew/write")) {
            if (userLevel == null || !userLevel.toString().equals("1")) {
                sendAlert(response, "관리자만 들어갈 수 있습니다.", "/");
                return false;
            }
        }


        return true;
    }

    // 알림 메시지를 보내는 공통 메서드
    private void sendAlert(HttpServletResponse response, String message, String redirectUrl) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + message + "'); location.href='" + redirectUrl + "';</script>");
        out.flush();
        out.close();
    }

}
