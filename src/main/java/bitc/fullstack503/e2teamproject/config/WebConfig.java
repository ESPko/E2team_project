package bitc.fullstack503.e2teamproject.config;

import bitc.fullstack503.e2teamproject.interceptor.LoginCheck;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheck())
                .addPathPatterns("/*")
                .addPathPatterns("/user/*")
                .addPathPatterns("/notice/write")
                .addPathPatterns("/event/write")
                .addPathPatterns("/crew/write")
                .addPathPatterns("/notice/edit/*")
                .addPathPatterns("/event/edit/*")
                .addPathPatterns("/crew/edit/*")
                .excludePathPatterns("/user/loginProcess.do", "/user/logout",  "/user/signupProcess.do",
                        "/user/checkDuplicate", "/user/", "/", "/notice", "/event", "/crew" ,"/rec");
    }
}

