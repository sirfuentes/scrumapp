package org.cfuentes.scrumapp.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("globalController")
@SessionScope
public class GlobalController {

	private Object entidad;

	public Object getEntidad() {
		return entidad;
	}

	public void setEntidad(Object entidad) {
		this.entidad = entidad;
	}
	
	
}
