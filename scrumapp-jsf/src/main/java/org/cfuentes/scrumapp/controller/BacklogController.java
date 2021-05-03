package org.cfuentes.scrumapp.controller;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.cfuentes.scrumapp.entity.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("backlogController")
@ViewScoped
public class BacklogController {

	@Autowired
	GlobalController globalController;
	
	Proyecto proyecto;
	
	@PostConstruct
	public void init() {
		proyecto = (Proyecto) globalController.getEntidad();
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
}
