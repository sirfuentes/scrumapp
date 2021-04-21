package org.cfuentes.scrumapp.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.cfuentes.scrumapp.entity.Proyecto;
import org.cfuentes.scrumapp.service.api.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("proyectoController")
@ViewScoped
public class ProyectoController {

	List<Proyecto> proyectos;
	List<Proyecto> proyectosSeleccionados;
	Proyecto proyectoSelec;
	
	@Autowired
	ProyectoService proyectoService;
	
	@PostConstruct
	public void init() {
		proyectos = proyectoService.findAll();
	 }
	 
 	public void guardarProyecto() {
		 proyectoService.saveOrUpdate(proyectoSelec);
	}
 	
 	public void eliminarProyecto() {
 		proyectoService.delete(proyectoSelec);
	}
 	
 	public void nuevoProyecto() {
 		proyectoSelec = new Proyecto();
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public List<Proyecto> getProyectosSeleccionados() {
		return proyectosSeleccionados;
	}

	public void setProyectosSeleccionados(List<Proyecto> proyectosSeleccionados) {
		this.proyectosSeleccionados = proyectosSeleccionados;
	}

	public Proyecto getProyectoSelec() {
		return proyectoSelec;
	}

	public void setProyectoSelec(Proyecto proyectoSelec) {
		this.proyectoSelec = proyectoSelec;
	}
 	
	
 	
}