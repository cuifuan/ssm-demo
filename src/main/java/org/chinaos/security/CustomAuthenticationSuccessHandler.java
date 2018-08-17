package org.chinaos.security;

import com.alibaba.fastjson.JSON;
import org.chinaos.util.ResultBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication auth
    ) throws IOException, ServletException {

        if ("application/json;charset=UTF-8".equals(request.getHeader("Content-Type"))) {
            /*
             * USED if you want to AVOID redirect to LoginSuccessful.htm in JSON authentication
             */
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            HttpSession session = request.getSession();
            System.out.println(session.getId()+"登陆成功的sessionid");
            session.setAttribute("user",userDetails);
            ResultBean resultBean=new ResultBean<>();
            resultBean.setMsg("success");
            resultBean.setCode(ResultBean.SUCCESS);
            resultBean.setData(userDetails);
            response.getWriter().print(JSON.toJSONString(resultBean));
            response.getWriter().flush();
        } else {
            super.onAuthenticationSuccess(request, response, auth);
        }
    }
}