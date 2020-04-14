package life.drift.movie.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import life.drift.movie.common.Const;
import life.drift.movie.exception.ResponseErrorCode;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.UserVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Component
@Service
public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        UserVO userVO = (UserVO) session.getAttribute(Const.CURRENT_USER);
        if (userVO != null) {
            return true;
        }
        //用户未登录
        try {
            response.reset();
            response.addHeader("Content-Type", "application/json;charset=utf-8");
            PrintWriter writer = response.getWriter();
            ServerResponse serverResponse = ServerResponse.createServerResponseByFail(ResponseErrorCode.NOT_LOGIN.getCode(), ResponseErrorCode.NOT_LOGIN.getMsg());
            ObjectMapper objectMapper = new ObjectMapper();
            String info = objectMapper.writeValueAsString(serverResponse);
            writer.write(info);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //客户端接收到服务端响应后 调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
