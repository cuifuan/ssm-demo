package org.chinaos.util;

import org.chinaos.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 * 被验证的委托人的身份
 * created by cfa  2018-08-02 下午 3:29
 **/
public class UserUtils {
    public static User getCurrentHr() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
