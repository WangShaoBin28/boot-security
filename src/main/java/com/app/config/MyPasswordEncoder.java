package com.app.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Package com.app.config
 * @ClassName MyPasswordEncoder
 * @Author shaobin.wang
 * @Date 2019/06/18 17:47
 * @Version 1.0
 * @Description:
 **/
@Component
class MyPasswordEncoderimplements implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
