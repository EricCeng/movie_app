package life.drift.movie.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        List<String> excludeUrl = new ArrayList<>();
        excludeUrl.add("/user/login");
        excludeUrl.add("/user/register");
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/user/**").excludePathPatterns(excludeUrl);
    }


}
