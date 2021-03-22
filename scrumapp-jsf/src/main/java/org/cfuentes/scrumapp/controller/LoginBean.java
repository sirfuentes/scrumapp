package org.cfuentes.scrumapp.controller;

import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.service.api.MiembroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;

@Component("loginController")
@SessionScope
public class LoginBean {

    private static final Logger logger = LoggerFactory.getLogger(LoginBean.class);

    private String email;
    private String password;
    private String passwordRep;
    private Miembro miembroRegistro;
    
    @Autowired
    MiembroService miembroService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostConstruct
    public void init() {
        logger.info("LoginBean.init()");
         miembroRegistro = new Miembro();
    }

    public void login() {
    	
    	
    }
    public void register() {
    	if (miembroRegistro.getPassword().equals(passwordRep)) {
    		miembroRegistro.setPassword(passwordEncoder.encode(miembroRegistro.getPassword()));
    		miembroService.saveOrUpdate(miembroRegistro);
    		miembroRegistro = new Miembro();
    	}
    	else {
    		//excepcion contrasena no iguales
    	}
    	
    }
    
    public String goToRegister() {
    	return "gotoregister";
    }
    
    public String goToLogin() {
    	return "gotologin";
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

	public String getPasswordRep() {
		return passwordRep;
	}

	public void setPasswordRep(String passwordRep) {
		this.passwordRep = passwordRep;
	}

	public Miembro getMiembroRegistro() {
		return miembroRegistro;
	}

	public void setMiembroRegistro(Miembro miembroRegistro) {
		this.miembroRegistro = miembroRegistro;
	}
	
	
	
}
