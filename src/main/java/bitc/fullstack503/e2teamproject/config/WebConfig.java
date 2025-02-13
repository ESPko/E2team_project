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
                .addPathPatterns("/board/*")
                .addPathPatterns("/user/*")
                .excludePathPatterns("/user/", "/user/loginProcess.do", "/user/logout", "/board/signup", "/user/signupProcess.do", "/user/checkDuplicate");
    }
}

