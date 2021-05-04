package org.cfuentes.scrumapp.controller;

import org.cfuentes.scrumapp.entity.Proyecto;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("globalController")
@SessionScope
public class GlobalController {

	private Object entidad;
	private Proyecto proyecto;
	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Object getEntidad() {
		return entidad;
	}

	public void setEntidad(Object entidad) {
		this.entidad = entidad;
	}
	
	
}
