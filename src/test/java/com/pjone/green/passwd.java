package com.pjone.green;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class passwd {
    public static void main(String[] args) {

    }
    @Test
    public void testPass(){
        String pass = "123456";
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        String hashPass = encode.encode(pass);
        System.out.println(hashPass);
    }

}
