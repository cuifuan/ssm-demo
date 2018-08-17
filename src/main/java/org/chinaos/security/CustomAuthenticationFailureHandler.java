package org.chinaos.security;

import com.alibaba.fastjson.JSON;
import org.chinaos.util.ResultBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception
    ) {
        try {
            if ("application/json;charset=UTF-8".equals(request.getHeader("Content-Type"))) {
                /*
                 * USED if you want to AVOID redirect to LoginSuccessful.htm in JSON authentication
                 */
                ResultBean resultBean = new ResultBean<>();
                resultBean.setMsg("error");
                resultBean.setCode(ResultBean.FAIL);
                response.getWriter().print(JSON.toJSONString(resultBean));
                response.getWriter().flush();
            } else {
                super.onAuthenticationFailure(request, response, exception);
            }
        }catch (IOException | ServletException e){
            System.out.println(e.getMessage()+"-------------------");
        }
    }
}
