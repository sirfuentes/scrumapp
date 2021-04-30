package org.cfuentes.scrumapp.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.cfuentes.scrumapp.entity.Miembro;
import org.cfuentes.scrumapp.entity.Proyecto;
import org.cfuentes.scrumapp.entity.UsuarioAutenticado;
import org.cfuentes.scrumapp.service.api.MiembroService;
import org.cfuentes.scrumapp.service.api.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("proyectoController")
@ViewScoped
public class ProyectoController {

	List<Proyecto> proyectos;
	List<Proyecto> proyectosSeleccionados;
	List<Miembro> productOwnerDisponibles;
	List<Miembro> scrumMasterDisponibles;
	Proyecto proyectoSelec;
	Miembro miembroAuth;
	
	
	@Autowired
	ProyectoService proyectoService;
	
	@Autowired
	MiembroService miembroService;
	
	@PostConstruct
	public void init() {
		miembroAuth = ((UsuarioAutenticado)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
		proyectos = proyectoService.findAll();
		productOwnerDisponibles = miembroService.findAll();
		scrumMasterDisponibles = miembroService.findAll();
		
	}

	public void guardarProyecto() {
		proyectoService.saveOrUpdate(proyectoSelec);
		proyectos = proyectoService.findAll();
	}

	public void eliminarProyecto() {
		proyectoService.delete(proyectoSelec);
		proyectos = proyectoService.findAll();
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

	public List<Miembro> getProductOwnerDisponibles() {
		return productOwnerDisponibles;
	}

	public void setProductOwnerDisponibles(List<Miembro> productOwnerDisponibles) {
		this.productOwnerDisponibles = productOwnerDisponibles;
	}

	public List<Miembro> getScrumMasterDisponibles() {
		return scrumMasterDisponibles;
	}

	public void setScrumMasterDisponibles(List<Miembro> scrumMasterDisponibles) {
		this.scrumMasterDisponibles = scrumMasterDisponibles;
	}

	public Miembro getMiembroAuth() {
		return miembroAuth;
	}

	public void setMiembroAuth(Miembro miembroAuth) {
		this.miembroAuth = miembroAuth;
	}

}
