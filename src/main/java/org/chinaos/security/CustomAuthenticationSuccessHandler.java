package org.chinaos.security;

import com.alibaba.fastjson.JSON;
import org.chinaos.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;


public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication auth
    ) throws IOException, ServletException {

        if ("application/json".equals(request.getHeader("Content-Type"))) {
            /*
             * USED if you want to AVOID redirect to LoginSuccessful.htm in JSON authentication
             */
            //登陆成功
//            session.setAttribute("user", obj);
            User userDetails = (User) SecurityContextHolder.getContext()
                    .getAuthentication()
                    .getPrincipal();
            HttpSession session = request.getSession(true);
            session.setAttribute("user",userDetails);
            Map map=new Hashtable();
            map.put("user",userDetails);
            map.put("responseCode","SUCCESS");
            response.getWriter().print(JSON.toJSONString(map));
            response.getWriter().flush();
        } else {
            super.onAuthenticationSuccess(request, response, auth);
        }
    }
}