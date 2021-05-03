package org.cfuentes.scrumapp.controller;


import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.service.api.MiembroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component("loginController")
@SessionScope
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

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
		logger.info("LoginController.init()");
		miembroRegistro = new Miembro();
	}

	public void login() {

	}

	public String logout() {
		SecurityContextHolder.clearContext();
		return "logout";
	}

	public String register() {
		if (miembroRegistro.getPassword().equals(passwordRep)) {
			miembroRegistro.setPassword(passwordEncoder.encode(miembroRegistro.getPassword()));
			miembroRegistro.setRol("ROLE_USER");

			miembroRegistro = miembroService.saveOrUpdate(miembroRegistro);
			//developerService.insertDeveloper(miembroRegistro.getIdMiembro());
			//productOwnerService.insertProductOwner(miembroRegistro.getIdMiembro());
			//scrumMasterService.insertScrumMaster(miembroRegistro.getIdMiembro());
			
			miembroRegistro = new Miembro();
			return "gotologin";
		} else {
			// excepcion contrasena no iguales

			passwordRep = "";
			miembroRegistro.setPassword("");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Las contraseñas no coinciden", "Las contraseñas deben ser iguales"));
			// FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("");
		}
		return "";

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
