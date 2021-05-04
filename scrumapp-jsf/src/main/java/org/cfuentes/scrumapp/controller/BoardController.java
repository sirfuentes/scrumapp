package org.cfuentes.scrumapp.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.entity.Proyecto;
import org.cfuentes.scrumapp.entity.UsuarioAutenticado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("boardController")
@ViewScoped
public class BoardController {

	Miembro miembroAuth;
	Proyecto proyecto;
	
	@Autowired
	GlobalController globalController;
	
	
	@PostConstruct
	public void init() {
		miembroAuth = ((UsuarioAutenticado)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		proyecto = (Proyecto) globalController.getEntidad();
	}


	public Miembro getMiembroAuth() {
		return miembroAuth;
	}


	public void setMiembroAuth(Miembro miembroAuth) {
		this.miembroAuth = miembroAuth;
	}


	public Proyecto getProyecto() {
		return proyecto;
	}


	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
}
