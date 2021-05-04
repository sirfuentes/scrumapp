package org.cfuentes.scrumapp.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.entity.UsuarioAutenticado;
import org.cfuentes.scrumapp.service.api.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("perfilController")
@ViewScoped
public class PerfilController {
	
	Miembro miembro;
	String password;
	String passwordRep;
	
	@Autowired
	MiembroService miembroService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init() {
		miembro = ((UsuarioAutenticado)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
	}
	
	public void guardarPerfil() {
		if (password == null || password.isEmpty()
				&& passwordRep == null || passwordRep.isEmpty()) {
			miembroService.saveOrUpdate(miembro);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Perfil actualizado", "La informacion se ha guardado correctamente."));
		}
		else if (password != null && !password.isEmpty() 
				&& passwordRep != null && !passwordRep.isEmpty()) {
			if (password.equals(passwordRep)) {
				miembro.setPassword(passwordEncoder.encode(password));
				miembroService.saveOrUpdate(miembro);
			}
			else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Las contraseñas no coinciden", "Las contraseñas deben ser iguales"));
		}
				
			
		}

	}

	public Miembro getMiembro() {
		return miembro;
	}

	public void setMiembro(Miembro miembro) {
		this.miembro = miembro;
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
	
	
}
