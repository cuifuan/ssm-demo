package org.chinaos.controller;

import org.chinaos.model.User;
import org.chinaos.security.UserService;
import org.chinaos.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 页面跳转控制器
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 登录账号或密码错误
     */
    private static final String EXCEPTIOIN_BAD = "BadCredentialsException";
    /**
     * 账号锁定错误
     */
    private static final String EXCEPTION_LOCKED = "LockedException";
    /**
     * 账号未启动错误
     */
    private static final String EXCEPTION_DISABLED = "DisabledException";
    /**
     * 密码凭证过期错误
     */
    private static final String EXCEPTION_CREDENTIALS = "CredentialsExpiredException";
    private static final String EXCEPTION_USERNAMENOTFOUND = "UsernameNotFoundException";

    @RequestMapping("/loginsuccess")
    public User success(){
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return user;
    }
    @RequestMapping("/loginerror")
    public String failurl(){
        return "login_fail";
    }


    @RequestMapping("/login_process1")
    @ResponseBody
    public String adminPage(){
        //test
        return "user";
    }

    @RequestMapping("/admin")
    public String rootPage(){
        //test
        return "testROOT";
    }

    @RequestMapping(value = {"/404","/Access_Denied"})
    public String errPage(HttpServletRequest request){
        return "404";
    }

    /**
     * 更改密码页
     * @return
     */
    @RequestMapping(value = "/changePasswordPage", method = RequestMethod.GET)
    public String changePasswordPage(){
        return "changePasswordPage";
    }

    /**
     * 用户主页
     * @return2
     */
    @GetMapping(value = "/currentUserName",produces = "application/json;charset=UTF-8")
    public String currentUserName(HttpServletRequest request){
        HttpSession session=request.getSession();
        Object usersession=session.getAttribute("user");
        User user;
        String username="游客";
        if(usersession!=null){
            user=(User)usersession;
            username=user.getUsername();
        }
        return username;
    }

    @RequestMapping(value ="reguser")
    public Map reguser(@RequestBody Map map){
        userService.insertUser(map);
        return map;
    }
    /**
     * 注册用户, 返回新对象的id
     *
     * @param map
     * @return
     */
    @PostMapping("/reguser")
    public ResultBean<Integer> add(@RequestBody Map map) {
        return new ResultBean<>(userService.insertUser(map));
    }


}
