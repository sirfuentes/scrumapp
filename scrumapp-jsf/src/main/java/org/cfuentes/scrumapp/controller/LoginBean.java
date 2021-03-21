package org.cfuentes.scrumapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;

@Component("loginController")
@SessionScope
public class LoginBean {

    private static final Logger logger = LoggerFactory.getLogger(LoginBean.class);

    private String email;
    private String password;

    @PostConstruct
    public void init() {
        logger.info("LoginBean.init()");
    }

    public void login() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
